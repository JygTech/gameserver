package org.jyg.gameserver.core.startup;

import com.google.protobuf.GeneratedMessageV3;
import org.jyg.gameserver.core.processor.HttpProcessor;
import org.jyg.gameserver.core.processor.ProtoProcessor;
import org.jyg.gameserver.core.util.Context;
import org.jyg.gameserver.core.util.IGlobalQueue;
import org.jyg.gameserver.core.util.RingBufferGlobalQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create by jiayaoguang at 2018年3月5日
 * 抽象启动类
 */

public abstract class AbstractBootstrap {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final IGlobalQueue globalQueue;

    private final Context context;

    protected volatile boolean isStart = false;

    public AbstractBootstrap() {
        this(new RingBufferGlobalQueue());
    }

    public AbstractBootstrap(IGlobalQueue globalQueue) {
        this(new Context(globalQueue));
    }

    public AbstractBootstrap(Context context) {
        this.globalQueue = context.getGlobalQueue();
        this.context = context;
//        this.globalQueue.getEventConsumerFactory().setContext(context);
    }

//    public void setEventConsumerFactory(EventConsumerFactory eventConsumerFactory) {
//        if (isStart) {
//            logger.error("oprete fail,server is already start ");
//            return;
//        }
//        eventConsumerFactory.setEventDispatcher(this.context.getEventDispatcher());
//        this.globalQueue.setEventConsumerFactory(eventConsumerFactory);
//
//    }

    public void registerSocketEvent(int msgId, ProtoProcessor<? extends GeneratedMessageV3> protoProcessor) {
        this.addProtoProcessor(msgId, protoProcessor);
    }

    public void addProtoProcessor(ProtoProcessor<? extends GeneratedMessageV3> protoProcessor) {
        int msgId = context.getMsgIdByProtoClass(protoProcessor.getProtoClass());
        this.context.getGlobalQueue().addProtoProcessor(msgId, protoProcessor , context);
    }

    public void addProtoProcessor(int msgId,ProtoProcessor<? extends GeneratedMessageV3> protoProcessor) {
        this.context.getGlobalQueue().addProtoProcessor(msgId, protoProcessor , context);
    }

    public void registerHttpEvent(String path, HttpProcessor processor){
        this.addHttpProcessor( path, processor);
    }

    public void addHttpProcessor(HttpProcessor processor) {
        if (isStart) {
            throw new IllegalArgumentException(" registerHttpProcessor fail ,server is start ");
        }
        String path = processor.getPath();
        if (path == null) {
            throw new IllegalArgumentException(" getProtoEventId -1 ");
        }
        this.context.getGlobalQueue().addHttpProcessor(path, processor, context);
    }


    public void addHttpProcessor(String path, HttpProcessor processor){
        processor.setPath(path);
        this.addHttpProcessor(processor);
    }

    public void registerSendEventIdByProto(int eventId, Class<? extends GeneratedMessageV3> protoClazz) throws Exception {
        this.addMsgId2ProtoMapping(eventId, protoClazz);
    }

    public void addMsgId2ProtoMapping(int eventId, Class<? extends GeneratedMessageV3> protoClazz) throws Exception {
        if (isStart) {
            throw new IllegalArgumentException(" registerHttpProcessor fail ,server is start ");
        }
        this.context.addMsgId2ProtoMapping(eventId, protoClazz);
    }

    public void addMsgId2ProtoMapping(int eventId, GeneratedMessageV3 defaultInstance) throws Exception {
        if (isStart) {
            throw new IllegalArgumentException(" registerHttpProcessor fail ,server is start ");
        }
        this.context.addMsgId2ProtoMapping(eventId, defaultInstance);
    }

    public Logger getLogger() {
        return logger;
    }

    public IGlobalQueue getGlobalQueue() {
        return globalQueue;
    }

    public Context getContext() {
        return context;
    }

    public final synchronized void start() throws InterruptedException{
        if (isStart) {
//            throw new IllegalStateException("server is already start");
            logger.error("server is already start ");
            return;
        }
        isStart = true;
        context.start();
        this.globalQueue.setContext(context);
        beforeStart();
        doStart();
    }

    protected void beforeStart() {

    }

    public abstract void doStart() throws InterruptedException;

    public void stop() throws InterruptedException{

    }

}