package com.test.hackerrank;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.util.CharsetUtil;

public class NettyServer {

	private Channel ch;
	public void run() throws Exception {
        final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        final EventLoopGroup workerGroup = new NioEventLoopGroup(2);
        try {
            final ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WebSocketServerInitializer());

            ch = b.bind("localhost", 9200).sync().channel();
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
	  private class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
	        @Override
	        public void initChannel(final SocketChannel ch) throws Exception {
	            final ChannelPipeline pipeline = ch.pipeline();
	            pipeline.addLast("http-request-decoder", new HttpRequestDecoder());
	            pipeline.addLast("aggregator", new HttpObjectAggregator(1));
	            pipeline.addLast("http-response-encoder", new HttpResponseEncoder());
	            pipeline.addLast("request-handler", new WebSocketServerProtocolHandler("/websocket"));
	            pipeline.addLast("handler", new Myhandler());
	        }
	    }
	  public static void main(final String[] args) throws Exception {
	        new NettyServer().run();
	    }

	public class Myhandler extends SimpleChannelInboundHandler<FullHttpRequest> {

		@Override
		protected void channelRead0(ChannelHandlerContext arg0, FullHttpRequest msg) throws Exception {
			KafkaProducer produce = new KafkaProducer();
			String value=null;
			List<String>text=new ArrayList<String>();
			JSONParser parser = new JSONParser(); 
			JSONObject json = new JSONObject();
			if (msg instanceof LastHttpContent) {
	            ByteBuf content = Unpooled.copiedBuffer("Hello World.", CharsetUtil.UTF_8);
	            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

	            QueryStringDecoder queryDecoder = new QueryStringDecoder(msg.getUri(),
	        			true);
	            String methodName = msg.getMethod().name();
	        	Map<String, List<String>> parameters = queryDecoder.parameters();
	        	for(String key:parameters.keySet()){
	        		text=parameters.get(key);
	        		for(String original:text){
	        			String tmp = original.substring(1, original.length()-1);
	        			String[] jsonString=tmp.split(",");
	        			for(String x:jsonString){
	        				String[] entry = x.split(":");
	        				json.put(entry[0], entry[1]);
	        			}
	        			produce.init(json);
	        			System.out.println(json);
	        		}
	        		
	        	}
	            ByteBuf data = msg.content();
	            System.out.println("POST/PUT length: " + data.readableBytes());
	            System.out.println("POST/PUT as string: ");
	            System.out.println("-- DATA --");
	            System.out.println(data.toString(StandardCharsets.UTF_8));
	            System.out.println("-- DATA END --");
	            
	            
	            

	            
	            
	            
	           
	        }
	    }

	    @Override
	    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	        ctx.flush();
	    }

		

	}
}
