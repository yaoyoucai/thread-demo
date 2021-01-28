package com.mapout;

/**
 * @author huanyao
 * @version 1.0
 * @ClassName Test.java
 * @Description TODO(用一句话描述该文件做什么)
 * @date 2021/1/28 4:06 下午
 */
public class Test {
    private static final long count=1000L;
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void serial() {
        long startTime = System.currentTimeMillis();
        int a=0;
        for (int i = 0; i <count ; i++) {
            a+=5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }

        long endTime = System.currentTimeMillis();
        long useTime = endTime - startTime;
        String message = String.format("serial use time:%sms",useTime);
        System.out.println(message);
    }

    /**
     * @title concurrency
     * @Description 并发
     * @author huanyao
     * @date 2021/1/28 4:06 下午
     * @throws
     */
    private static void concurrency() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(){
            @Override
            public void run() {
                int a=0;
                for (int i = 0; i <count ; i++) {
                    a+=5;
                }
            }
        };
        thread.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();


        long endTime = System.currentTimeMillis();
        long useTime = endTime - startTime;
        String message = String.format("concurrency use time:%sms",useTime);
        System.out.println(message);
    }
}
