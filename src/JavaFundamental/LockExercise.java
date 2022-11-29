package JavaFundamental;

import java.util.concurrent.locks.ReentrantLock;

class SubThread extends Thread {

    public static int cnt;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            lock.lock();
            try {
                cnt++;
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockExercise {
    public static void main(String[] args) throws InterruptedException {
        SubThread sub1 = new SubThread();
        SubThread sub2 = new SubThread();

        sub1.setName("thread-1");
        sub2.setName("thread-2");

        sub1.start();
        sub2.start();

        sub1.join();
        sub2.join();
        System.out.println(SubThread.cnt);
    }
}
