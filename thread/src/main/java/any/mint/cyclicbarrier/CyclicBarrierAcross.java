package any.mint.cyclicbarrier;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierAcross {

    public static void main(String[] args) throws IOException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Thread(new Runner(barrier, "小明")));
        executor.submit(new Thread(new Runner(barrier, "小乖")));
        executor.submit(new Thread(new Runner(barrier, "乔丹")));
        executor.shutdown();
    }
        static class Runner extends Thread {
            // 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
            private CyclicBarrier barrier;
            private String name;

            public Runner(CyclicBarrier barrier, String name) {
                super();
                this.barrier = barrier;
                this.name = name;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        int time = new Random().nextInt(1000);
                        Thread.sleep(1);
                        System.out.println(new Date() +" "+ name + ", 翻越第" + i + "个障碍物, 使用了"+ time + "ms");
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    barrier.reset();
                }
            }
    }
}

