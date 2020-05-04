package org.gameserver.auth.processor;

import com.google.inject.Inject;
import com.jyg.net.Response;
import com.jyg.processor.ProtoProcessor;
import com.jyg.proto.p_auth_sm.p_sm_auth_response_receive_token;
import com.jyg.session.Session;
import org.gameserver.auth.bean.UserLoginInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * created by jiayaoguang at 2018年4月9日
 */
public class TokenReceiveSuccessProtoProcessor extends ProtoProcessor<p_sm_auth_response_receive_token> {

	
	TokenSendHttpProcessor tokenSendHttpProcessor;
	
	
	@Inject
	public TokenReceiveSuccessProtoProcessor(TokenSendHttpProcessor tokenSendHttpProcessor) throws InstantiationException, IllegalAccessException {
		super(p_sm_auth_response_receive_token.newBuilder().build());
		this.tokenSendHttpProcessor =tokenSendHttpProcessor;
	}

	@Override
	public void process(Session session, p_sm_auth_response_receive_token msg) {
		long requestId = msg.getRequestId();
		String token  = msg.getToken();
		UserLoginInfo userLoginInfo = tokenSendHttpProcessor.getUserLoginInfo(requestId);
		
		Response httpResponse = new Response( userLoginInfo.getChannel() );
		
		Map<String,String> map = new HashMap<>();
		
		map.put("username", userLoginInfo.getUsername());
		map.put("host", msg.getIp());
		map.put("port", msg.getPort()+"");
		
		byte[] bytes = ftlLoader.getFtl("index.ftl" ,map );
		
		httpResponse.writeAndFlush(bytes);
		
	}

}

