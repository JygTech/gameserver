package org.jyg.gameserver.core.util;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import org.jyg.gameserver.core.bean.ServerConfig;
import org.jyg.gameserver.core.consumer.Consumer;
import org.jyg.gameserver.core.handle.NettyHandlerFactory;
import org.jyg.gameserver.core.manager.ConsumerManager;
import org.jyg.gameserver.core.manager.EventLoopGroupManager;
import org.jyg.gameserver.core.manager.ExecutorManager;
import org.jyg.gameserver.core.manager.SingleThreadExecutorManagerPool;

import java.lang.reflect.InvocationTargetException;

/**
 * create by jiayaoguang on 2020/5/3
 */
public class Context {

    private static final String DEFAULT_CONFIG_FILE_NAME = "jyg.properties";
//    private String configFileName = DEFAULT_CONFIG_FILE_NAME;

    private final Consumer defaultConsumer;
    private final EventLoopGroupManager eventLoopGroupManager;
//    private final ExecutorManager executorManager;

    private volatile boolean isStart = false;

    private final ServerConfig serverConfig = new ServerConfig();

    private final ConsumerManager consumerManager;

//    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    //TODO I think ...
    private final SingleThreadExecutorManagerPool singleThreadExecutorManagerPool;

    private Object2IntMap<Class<? extends MessageLite>> protoClazz2MsgidMap = new Object2IntOpenHashMap<>();
    private Int2ObjectMap<MessageLite> msgId2ProtoMap = new Int2ObjectOpenHashMap<>();


    private final NettyHandlerFactory nettyHandlerFactory;

    public Context(Consumer defaultConsumer) {
        this(defaultConsumer ,DEFAULT_CONFIG_FILE_NAME );
    }

    public Context(Consumer defaultConsumer , String configFileName) {
        this.defaultConsumer = defaultConsumer;
        this.eventLoopGroupManager = new EventLoopGroupManager();
//        this.executorManager = new ExecutorManager(10, defaultConsumer);
        this.singleThreadExecutorManagerPool = new SingleThreadExecutorManagerPool(defaultConsumer);

        defaultConsumer.setId(ConsumerManager.DEFAULT_CONSUMER_ID);
        defaultConsumer.setContext(this);
        this.consumerManager = new ConsumerManager(this);
        this.consumerManager.addConsumer(defaultConsumer);

        this.nettyHandlerFactory = new NettyHandlerFactory(this);

        loadServerConfig(configFileName);
    }

    public Consumer getDefaultConsumer() {
        return defaultConsumer;
    }

    public EventLoopGroupManager getEventLoopGroupManager() {
        return eventLoopGroupManager;
    }


    public void addMsgId2ProtoMapping(int msgId, Class<? extends MessageLite> protoClazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MessageLite defaultInstance = (MessageLite)protoClazz.getMethod("getDefaultInstance").invoke(null);
        addMsgId2ProtoMapping(msgId , defaultInstance);
    }

    public void addMsgId2ProtoMapping(int msgId,  MessageLite defaultInstance) {
        this.protoClazz2MsgidMap.put(defaultInstance.getClass(), msgId);
        this.msgId2ProtoMap.put(msgId , defaultInstance);
    }

    public Parser<? extends MessageLite> getProtoParserByMsgId (int msgId){

        MessageLite messageLite = msgId2ProtoMap.get(msgId);
        if(messageLite == null){
            return null;
        }

        return messageLite.getParserForType();
    }


    public int getMsgIdByProtoClass( Class<? extends MessageLite> protoClass) {

        return protoClazz2MsgidMap.getInt(protoClass);
    }


    public ExecutorManager getSingleThreadExecutorManager(long playerUid) {
        return singleThreadExecutorManagerPool.getSingleThreadExecutorManager(playerUid);
    }

    public synchronized void start() {
        if(isStart){
            AllUtil.println(" already start .... ");
            return;
        }
        this.isStart = true;
        this.protoClazz2MsgidMap = Object2IntMaps.unmodifiable(this.protoClazz2MsgidMap);
        this.msgId2ProtoMap = Int2ObjectMaps.unmodifiable(this.msgId2ProtoMap);

//        loadServerConfig(configFileName);
    }

    public synchronized void loadServerConfig(String configFileName){
        if(isStart){
            AllUtil.println(" already start .... ");
            return;
        }
        AllUtil.properties2Object(configFileName, serverConfig);
    }


    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    public boolean isStart() {
        return isStart;
    }

    public ConsumerManager getConsumerManager() {
        return consumerManager;
    }

    public NettyHandlerFactory getNettyHandlerFactory() {
        return nettyHandlerFactory;
    }


    //    public ScheduledExecutorService getScheduledExecutorService() {
//        return scheduledExecutorService;
//    }
}
