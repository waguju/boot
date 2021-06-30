package com.ndxs.boot.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: waguju
 * @time: 2021.6.30 16:38
 */
public class RateLimiterTest 
{
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final int THREAD_COUNT = 25;

    @Test
    public void testRateLimiter1() {
        RateLimiter rateLimiter = RateLimiter.create(5);
        //System.out.println("father rateLimiter.getRate="+rateLimiter.getRate());

        Thread[] ts = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i] = new Thread(new RateLimiterThread(rateLimiter), "RateLimiterThread-" + i);
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i].start();
        }

        for (;;);
    }

    public class RateLimiterThread implements Runnable {

        private RateLimiter rateLimiter;

        public RateLimiterThread(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }

        @Override
        public void run() {
            rateLimiter.acquire();
            System.out.println(rateLimiter.getRate());

            System.out.println(Thread.currentThread().getName() + "获取到了令牌，时间 = " + FORMATTER.format(new Date()));
        }
    }
}
