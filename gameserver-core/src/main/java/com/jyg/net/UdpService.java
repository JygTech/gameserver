package com.jyg.net;

import com.jyg.handle.initializer.InnerSocketServerInitializer;
import com.jyg.handle.initializer.WebSocketServerInitializer;
import com.jyg.proto.p_common;
import com.jyg.util.GlobalQueue;
import com.jyg.util.RemotingUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollDatagramChannel;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiayaoguang on 2018/7/6.
 */
public class UdpService implements Service {

    protected static final EventLoopGroup bossGroup;

    protected static final EventLoopGroup workGroup;

    static {
        bossGroup = new NioEventLoopGroup(1,
            (Runnable r) -> new Thread(r, "ACCEPT_THREAD"));

        if (RemotingUtil.useEpoll()) {


            workGroup = new EpollEventLoopGroup(8, new ThreadFactory() {
                private AtomicInteger threadIndex = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "EPOLL_IO_THREAD_" + threadIndex.incrementAndGet());
                }
            });
        } else {
            workGroup = new NioEventLoopGroup(8, new ThreadFactory() {
                private AtomicInteger threadIndex = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "NIO_IO_THREAD_" + threadIndex.incrementAndGet());
                }
            });
        }
    }

    private ChannelInitializer<Channel> initializer = new InnerSocketServerInitializer();
    private final int port;



    public UdpService(int port, ChannelInitializer<Channel> initializer){
        if (port < 0) {
            throw new IllegalArgumentException("port number cannot be negative ");
        }
        this.port = port;
        this.initializer = initializer;
    }

    @Override
    public void start() throws InterruptedException {
        if (initializer == null) {
//            throw new Exception("initializer must is not null");
        }

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group( workGroup);

        bootstrap.channel(RemotingUtil.useEpoll() ? EpollDatagramChannel.class : NioDatagramChannel.class);
        bootstrap.handler(initializer);
//        bootstrap.childHandler(initializer);

        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        // tcp等待三次握手队列的长度
        bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        // 指定等待时间为0，此时调用主动关闭时不会发送FIN来结束连接，而是直接将连接设置为CLOSE状态，
        // 清除套接字中的发送和接收缓冲区，直接对对端发送RST包。
//        bootstrap.childOption(ChannelOption.SO_LINGER, 0);
//        bootstrap.childOption(ChannelOption.SO_RCVBUF, 64 * 1024);
//        bootstrap.childOption(ChannelOption.SO_SNDBUF, 64 * 1024);
//        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, false);// maybe useless
//        bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
//        bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        bootstrap.bind(port).sync().channel().writeAndFlush(p_common.p_common_response_pong.getDefaultInstance());
    }

    @Override
    public void stop() {

    }

    /**
     * 停止服务
     */
    public static void shutdown() {
        if (bossGroup != null && !bossGroup.isShutdown()) {
            bossGroup.shutdownGracefully();
        }
        if (workGroup != null && !workGroup.isShutdown()) {
            workGroup.shutdownGracefully();
        }
        GlobalQueue.shutdown();
    }

}
