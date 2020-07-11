package org.jyg.gameserver.auth;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jyg.gameserver.auth.processor.*;
import org.jyg.gameserver.core.enums.ProtoEnum;
import org.jyg.gameserver.core.startup.GameServerBootstarp;
import org.jyg.gameserver.core.util.redis.RedisCacheClient;
import org.jyg.gameserver.auth.module.AuthModule;
import org.jyg.gameserver.proto.MsgLoginReply;
import org.jyg.gameserver.proto.MsgLoginRequest;
import org.jyg.gameserver.proto.p_auth_sm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class AuthBootstarp
{

	private static final Logger logger = LoggerFactory.getLogger(AuthBootstarp.class);

    public static void main ( String[] args ) throws Exception 
    {
    	
    	Injector injector = Guice.createInjector(new AuthModule());
    	
    	
    	GameServerBootstarp bootstarp = new GameServerBootstarp();
	    RedisCacheClient redisCacheClient = injector.getInstance(RedisCacheClient.class);
	    redisCacheClient.init();

//        bootstarp.registerHttpEvent("/index000", injector.getInstance(TokenSendHttpProcessor.class));
        
        bootstarp.registerHttpEvent("/index", injector.getInstance(LoginHttpProcessor.class));

        bootstarp.registerHttpEvent("/checkToken", injector.getInstance(CheckLoginHttpProcessor.class));

        bootstarp.registerSendEventIdByProto(ProtoEnum.P_AUTH_SM_REQUEST_SEND_TOKEN.getEventId(),
        		p_auth_sm.p_auth_sm_request_send_token.class);

//        bootstarp.addMsgId2ProtoMapping(1001 , MsgLoginReply.class);
//        bootstarp.addMsgId2ProtoMapping(1000 , MsgLoginRequest.class);

//        bootstarp.addProtoProcessor(1000, injector.getInstance(LoginProtoProcessor.class));


        bootstarp.addHttpService(8088);

//        bootstarp.addTcpService(8081);
        
        bootstarp.registerSocketEvent(ProtoEnum.P_SM_AUTH_RESPONSE_RECEIVE_TOKEN.getEventId(), 
        		injector.getInstance(TokenReceiveSuccessProtoProcessor.class));
        
        bootstarp.start();
        logger.error(" start success ");
    }
}
