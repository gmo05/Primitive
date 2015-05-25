package com.gmo.util.httpclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;

public class HttpClientInboundHandlerTest extends ChannelInboundHandlerAdapter {
	private static Log log = LogFactory.getLog(HttpClientInboundHandlerTest.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse) 
        {
            HttpResponse response = (HttpResponse) msg;
            log.info("content_type:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
            log.info("content_length:" + response.headers().get(HttpHeaders.Names.CONTENT_LENGTH));
        }
        if(msg instanceof HttpContent)
        {
            HttpContent content = (HttpContent)msg;
            ByteBuf buf = content.content();
            log.info("read content: " + buf.toString(io.netty.util.CharsetUtil.UTF_8));
            buf.release();
        }
    }
}