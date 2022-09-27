package com.paigu.interview.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 两个线程
 *
 * @author liao
 * @date 2022/08/21
 */
public class TwoThread {


    private Sync sync = new Sync();

    public static class Sync extends AbstractQueuedSynchronizer {

        public Sync() {
            setState(2);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int available = getState();
                int remaining = available - arg;
                if (remaining < 0 || compareAndSetState(available, remaining)) {
                    return remaining;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int state = getState();
                int remaining = state + arg;
                if (compareAndSetState(state, remaining)) {
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unLock() {
        sync.releaseShared(1);
    }
}
