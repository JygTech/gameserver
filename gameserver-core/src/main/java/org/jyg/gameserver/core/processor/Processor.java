package org.jyg.gameserver.core.processor;

import org.jyg.gameserver.core.data.EventData;
import org.jyg.gameserver.core.session.Session;

/**
 * created by jiayaoguang at 2017年12月16日
 */
public interface Processor<T> extends Cloneable {
	void process(Session session , EventData<T> event);
	
}

