package com.jyg.tcp.ping;

import com.jyg.processor.ProtoProcessor;
import com.jyg.processor.ProtoResponse;
import com.jyg.proto.p_sm_scene.p_scene_sm_response_pong;
import com.jyg.proto.p_sm_scene.p_sm_scene_request_ping;
import com.jyg.startup.TcpClient;
import io.netty.channel.Channel;

/**
 * Hello world!
 *
 */
public class PingCLient {
	public static void main(String[] args) throws Exception {

		ProtoProcessor<p_scene_sm_response_pong> pongProcessor = new ProtoProcessor<p_scene_sm_response_pong>(
				p_scene_sm_response_pong.getDefaultInstance()) {

			@Override
			public void processProtoMessage(p_scene_sm_response_pong msg, ProtoResponse response) {
				System.out.println("receive pong msg");
				// response.writeMsg(p_scene_sm_response_pong.newBuilder());
				
			}

		};

		final TcpClient client = new TcpClient();

		client.registerSendEventIdByProto(1, p_sm_scene_request_ping.class);
		client.registerSocketEvent(2, pongProcessor);

		client.start();

		final Channel channel = client.connect("localhost", 8080);
		channel.writeAndFlush(p_sm_scene_request_ping.newBuilder());


		// client.close();
	}
}
