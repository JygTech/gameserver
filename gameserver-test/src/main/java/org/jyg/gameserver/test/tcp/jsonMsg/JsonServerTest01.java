package org.jyg.gameserver.test.tcp.jsonMsg;

import org.jyg.gameserver.core.data.EventData;
import org.jyg.gameserver.core.msg.ByteMsgObj;
import org.jyg.gameserver.core.processor.ByteMsgObjProcessor;
import org.jyg.gameserver.core.session.Session;
import org.jyg.gameserver.core.startup.GameServerBootstrap;
import org.jyg.gameserver.core.util.AllUtil;


/**
 * Hello world!
 */
public class JsonServerTest01 {

    public static class ChatMsgObj implements ByteMsgObj {
        private int type;
        private String conetnt;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getConetnt() {
            return conetnt;
        }

        public void setConetnt(String conetnt) {
            this.conetnt = conetnt;
        }
    }

    public static void main(String[] args) throws Exception {
        GameServerBootstrap bootstarp = new GameServerBootstrap();

        ByteMsgObjProcessor<ChatMsgObj> chatProcessor = new ByteMsgObjProcessor<ChatMsgObj>(ChatMsgObj.class) {
            @Override
            public void process(Session session, EventData<ChatMsgObj> event) {
                AllUtil.println(" ========================= get json " + event.getData().getConetnt());
                ChatMsgObj chatMsgObj = new ChatMsgObj();
                chatMsgObj.setType(1009);
                chatMsgObj.setConetnt("hello world");
                session.writeMessage(chatMsgObj);
            }
        };


//        bootstarp.getContext().addMsgId2JsonMsgCLassMapping(8, ChatMsgObj.class);
        bootstarp.getDefaultConsumer().addProcessor(108, chatProcessor);

        bootstarp.addTcpService(8088);

        bootstarp.start();
    }
}
