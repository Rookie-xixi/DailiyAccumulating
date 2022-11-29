package JavaFundamental;
// Java实现多线程
// 两种方法：1.继承Thread类；2.实现Runnable接口


class Worker extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("HELLO! " + i + " " + this.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}


//class Worker implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("HELLO! " + i);
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}



public class MultiThreadExercise {
    public static void main(String[] args) throws InterruptedException {

        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        worker1.setName("thread-1");
        worker2.setName("thread-2");

        worker1.setDaemon(true);
        worker2.setDaemon(true);

        worker1.start();
        worker2.start();

//        worker1.join(5000);
//        // interrupt只能中断在sleep和wait阶段的线程，并不能中断所有线程。
//        worker1.interrupt();

        //守护线程，当所有非守护线程结束后，操作系统会关闭所有守护线程
        Thread.sleep(5000);
//        System.out.println("Main  thread: Thread-1 不等了");
        System.out.println("Main thread finished!");


        /* 法2
        new Thread(new Worker()).start();
        new Thread(new Worker()).start();
         */


    }
}
