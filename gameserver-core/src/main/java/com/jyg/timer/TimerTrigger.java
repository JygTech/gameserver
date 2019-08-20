package com.jyg.timer;
/**
 * created by jiayaoguang at 2018年3月22日
 */

import java.util.PriorityQueue;

public class TimerTrigger {

    private final PriorityQueue<Timer> timerQueue = new PriorityQueue<>(128);

    public void addTimer(Timer timer) {
        timerQueue.add(timer);
    }

    public void cancelTimer(Timer timer){
        timer.cancel();
    }

    public void tickTigger() {

        for ( ; ; ) {
            Timer timer = timerQueue.peek();
            if (timer == null) {
                return;
            }
            if (timer.getTriggerTime() > System.currentTimeMillis()) {
                return;
            }
            timerQueue.poll();
            if (timer.isEnd() || timer.isCancel()) {
                continue;
            }

            timer.trigger();

            timerQueue.offer(timer);
        }

    }
}
