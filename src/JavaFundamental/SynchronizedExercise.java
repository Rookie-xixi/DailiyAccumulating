package JavaFundamental;

//// synchronize用法1-加到代码块上
//class Count {
//    public int cnt = 0;
//}
//
//class SynSample extends Thread {
//    public final Count count;
//    public SynSample(Count count) {
//        this.count = count;
//    }
//    @Override
//    public void run() {
//        synchronized (count) {
//            for (int i = 0; i < 100000; i++) {
//                count.cnt++;
//            }
//        }
//    }
//}

// synchronize用法2， 加在函数上，锁加在this对象上
// class SynSample implements Runnable {
//    public static int cnt = 0;
//    private synchronized void work() {
//        for (int i = 0; i < 1e5; i++) {
//            cnt++;
//        }
//    }
//    @Override
//    public void run() {
//        work();
//    }
//}

// wait与notify用法
class SynSample extends Thread {
    private  final Object object;
    private final boolean needWait;
    public SynSample(Object object, boolean needWait) {
        this.object = object;
        this.needWait = needWait;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                if (needWait) {
                    object.wait(1000);
                    System.out.println(this.getName() + ":被唤醒了 ！");
                    Thread.sleep(1000);
                } else {
                    object.notify();
                    System.out.println("去唤醒其他线程了！");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class SynchronizedExercise {
    public static void main(String[] args) throws InterruptedException {
        // 法1
//        Count count = new Count();
//        SynSample ss1 = new SynSample(count);
//        SynSample ss2 = new SynSample(count);
//        ss1.start();
//        ss2.start();
//        ss1.join();
//        ss2.join();
//        System.out.println(count.cnt);

        // 法2
//        SynSample ss = new SynSample();
//        Thread ss1 = new Thread(ss);
//        Thread ss2 = new Thread(ss);
//        ss1.start();
//        ss2.start();
//        ss1.join();
//        ss2.join();
//        System.out.println(SynSample.cnt);

        // wait/notify用法
        Object object = new Object();
        for (int i = 0; i < 5; i++) {
            SynSample ss = new SynSample(object, true);
            ss.setName("thread-" +i);
            ss.start();
        }

        SynSample ss = new SynSample(object, false);
        ss.setName("thread-" + 5);
        Thread.sleep(2000);
        ss.start();
    }
}
