package any.mint;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 滨江实验小学的小朋友举行秋季运动会，其中有一个项目，名叫”协同作战”，玩法如下：
 * 每3个小朋友为一组，依次翻越4个障碍，要求组内所有小朋友都翻越其中一个障碍后，才能开始翻越下一个障碍。
 * 2019-10-30 15:24:54 小明, 翻越了第0个障碍物, 使用了 1.494s
 * 2019-10-30 15:24:54 乔丹, 翻越了第0个障碍物, 使用了 1.755s
 * 2019-10-30 15:24:55 小乖, 翻越了第0个障碍物, 使用了 2.129s
 * 2019-10-30 15:24:56 小乖, 翻越了第1个障碍物, 使用了 1.011s
 * 2019-10-30 15:24:56 小明, 翻越了第1个障碍物, 使用了 1.627s
 * 2019-10-30 15:24:58 乔丹, 翻越了第1个障碍物, 使用了 2.78s
 * 2019-10-30 15:24:59 乔丹, 翻越了第2个障碍物, 使用了 1.682s
 * 2019-10-30 15:24:59 小乖, 翻越了第2个障碍物, 使用了 1.729s
 * 2019-10-30 15:25:00 小明, 翻越了第2个障碍物, 使用了 1.963s
 * 2019-10-30 15:25:01 乔丹, 翻越了第3个障碍物, 使用了 1.04s
 * 2019-10-30 15:25:01 小明, 翻越了第3个障碍物, 使用了 1.282s
 * 2019-10-30 15:25:02 小乖, 翻越了第3个障碍物, 使用了 2.654s
 *
 */

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

