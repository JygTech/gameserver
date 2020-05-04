package com.jyg.manager;

import com.jyg.util.IGlobalQueue;

/**
 * create on 2020/5/4 by jiayaoguang
 */
public class SingleThreadExecutorManager extends ExecutorManager {

	public SingleThreadExecutorManager(IGlobalQueue globalQueue) {
		super(1, globalQueue);
	}
}
