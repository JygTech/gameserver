package com.jyg.manager;

import com.jyg.util.AsynCallEvent;
import com.jyg.util.AsynEventAndCallBackRunnable;
import com.jyg.util.CallBackEvent;
import com.jyg.util.IGlobalQueue;

import java.util.concurrent.*;

/**
 * create on 2019/8/15 by jiayaoguang
 */
public class ExecutorManager {

	private final ExecutorService executor;
	private final IGlobalQueue globalQueue;
	public ExecutorManager(IGlobalQueue globalQueue) {
		this(10 , globalQueue);
	}

	public ExecutorManager(int poolSize,IGlobalQueue globalQueue) {
		this(poolSize,poolSize , globalQueue);
	}

	public ExecutorManager(int corePoolSize,int maxPoolSize,IGlobalQueue globalQueue) {
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1024*16);
		executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 3 * 60 * 1000L, TimeUnit.MILLISECONDS, workQueue, new ThreadPoolExecutor.DiscardPolicy());
		((ThreadPoolExecutor) executor).allowCoreThreadTimeOut(false);
		this.globalQueue = globalQueue;
	}


	public void execute(Runnable runnable) {
		executor.execute(runnable);
	}

//	public void execute(AsynEventAndCallBackEvent asynEventAndCallBackEvent) {
//		executor.execute(asynEventAndCallBackEvent);
//	}

	/**
	 * @param asynCallEvent 异步Runnable 由线程池线程执行
	 * @param callBackEvent 回调Runnable 由主逻辑线程执行
	 */
	public void execute(AsynCallEvent asynCallEvent, CallBackEvent callBackEvent) {
		executor.execute(new AsynEventAndCallBackRunnable(asynCallEvent , callBackEvent, globalQueue));
	}



	public Future submit(Runnable runnable) {
		return executor.submit(runnable);
	}

	public <T> Future<T> submit(Callable<T> callable) {
		return executor.submit(callable);
	}

	public void shutdown() {
		executor.shutdown();
	}

	public void shutdownNow() {
		executor.shutdownNow();
	}
}