package org.jyg.gameserver.test.tcp.chat;

import org.jyg.gameserver.core.processor.ProtoProcessor;
import org.jyg.gameserver.core.session.Session;
import org.jyg.gameserver.core.startup.GameServerBootstarp;
import org.jyg.gameserver.test.proto.MsgChat;
import org.jyg.gameserver.test.proto.p_test.p_sm_scene_chat;


/**
 * Hello world!
 *
 */
public class ServerTest01 
{
    public static void main( String[] args ) throws Exception{
        GameServerBootstarp bootstarp = new GameServerBootstarp();
        
        ProtoProcessor<MsgChat> chatProcessor = new ProtoProcessor<MsgChat>(MsgChat.getDefaultInstance()) {
        	@Override
			public void process(Session session, MsgChat msg) {
        		
        		System.out.println(msg.getContent() );
        		if("bye".equals(msg.getContent() )) {
        			return;
        		}
        		
        		session.writeMessage(p_sm_scene_chat.newBuilder().setMsg("i just think so ,hello world too"));
        	}
			
        };
//		bootstarp.addMsgId2ProtoMapping(1, p_sm_scene_request_ping.getDefaultInstance());
//		bootstarp.addMsgId2ProtoMapping(2, p_scene_sm_response_pong.getDefaultInstance());
//
//		bootstarp.addMsgId2ProtoMapping(3, p_scene_sm_chat.getDefaultInstance());
//		bootstarp.addMsgId2ProtoMapping(4, p_sm_scene_chat.getDefaultInstance());

		bootstarp.addMsgId2ProtoMapping(5, MsgChat.getDefaultInstance());


		bootstarp.addProtoProcessor(chatProcessor);
        

		bootstarp.addTcpService(8080);
        
        bootstarp.start();
    }
}
