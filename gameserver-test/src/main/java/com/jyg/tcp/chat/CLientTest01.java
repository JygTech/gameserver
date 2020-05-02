package com.jyg.tcp.chat;

import org.junit.Test;

import com.jyg.processor.ProtoProcessor;
import com.jyg.processor.ProtoResponse;
import com.jyg.proto.p_sm_scene.p_scene_sm_chat;
import com.jyg.proto.p_sm_scene.p_sm_scene_chat;
import com.jyg.proto.p_test.p_scene_sm_response_pong;
import com.jyg.proto.p_test.p_sm_scene_request_ping;
import com.jyg.startup.TcpClient;

/**
 * Hello world!
 *
 */
public class CLientTest01
{
    public static void main( String[] args ) throws Exception
    {
    	
    	ProtoProcessor<p_sm_scene_request_ping> pingProcessor = new ProtoProcessor<p_sm_scene_request_ping>(p_sm_scene_request_ping.getDefaultInstance()) {

			@Override
			public void processProtoMessage(p_sm_scene_request_ping msg, ProtoResponse response) {
				System.out.println("receive ping msg");
				response.writeMsg(p_scene_sm_response_pong.newBuilder());
				
			}
			
        };
        ProtoProcessor<p_sm_scene_chat> receiveChatProcessor = new ProtoProcessor<p_sm_scene_chat>(p_sm_scene_chat.getDefaultInstance()) {
        	int num = 0;
			@Override
			public void processProtoMessage(p_sm_scene_chat msg, ProtoResponse response) {
				System.out.println("receive msg "+num+":"+msg.getMsg());
				num++;
				if(num==10) {
					response.writeMsg( p_scene_sm_chat.newBuilder().setMsg("bye"));
					return;
				}
				response.writeMsg( p_scene_sm_chat.newBuilder().setMsg("hello world!"));
			}
			
        };
        
        
    	
        TcpClient client = new TcpClient();
        
        client.registerSocketEvent(1, pingProcessor);
        
        client.registerSendEventIdByProto(2, p_scene_sm_response_pong.class);
        
        client.registerSendEventIdByProto(3, p_scene_sm_chat.class);
        
        client.registerSocketEvent(4, receiveChatProcessor);

        client.start();

        client.connect("localhost",8080);
        
        
        client.write(p_scene_sm_chat.newBuilder().setMsg("hello world!"));
        
//        client.close();
    }
    
    @Test
    public void test01() {
    	char u = '　';
    	System.out.println((int)(char)(u*100));
    }
}
