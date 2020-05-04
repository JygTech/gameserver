package com.jyg.tcp.chat;

import com.jyg.processor.ProtoProcessor;
import com.jyg.processor.ProtoResponse;
import com.jyg.proto.p_test.p_scene_sm_chat;
import com.jyg.proto.p_test.p_scene_sm_response_pong;
import com.jyg.proto.p_test.p_sm_scene_chat;
import com.jyg.proto.p_test.p_sm_scene_request_ping;
import com.jyg.session.Session;
import com.jyg.startup.GameServerBootstarp;


/**
 * Hello world!
 *
 */
public class ServerTest01 
{
    public static void main( String[] args ) throws Exception{
        GameServerBootstarp bootstarp = new GameServerBootstarp();
        
        
        ProtoProcessor<p_sm_scene_request_ping> processor = new ProtoProcessor<p_sm_scene_request_ping>(p_sm_scene_request_ping.getDefaultInstance()) {
        	@Override
			public void process(Session session, p_sm_scene_request_ping msg) {
        		System.out.println("i just think so");
        		session.writeMessage( p_scene_sm_response_pong.newBuilder());
        	}
			
        };
        
        ProtoProcessor<p_scene_sm_chat> chatProcessor = new ProtoProcessor<p_scene_sm_chat>(p_scene_sm_chat.getDefaultInstance()) {
        	@Override
			public void process(Session session, p_scene_sm_chat msg) {
        		
        		System.out.println(msg.getMsg() );
        		if("bye".equals(msg.getMsg())) {
        			return;
        		}
        		
        		session.writeMessage(p_sm_scene_chat.newBuilder().setMsg("i just think so ,hello world too"));
        	}
			
        };
        
		System.out.println(processor.getProtoClassName());
        
        bootstarp.registerSocketEvent(1, processor);
        
        
        bootstarp.registerSocketEvent(3, chatProcessor);
        
        bootstarp.registerSendEventIdByProto(4, p_sm_scene_chat.class);
        
        
		bootstarp.addTcpService(8080);
        
        bootstarp.start();
    }
}
