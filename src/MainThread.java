public class MainThread {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new MyRunnableClass());
//        Thread t2 = new Thread(new MyRunnableClass());
//
//        t1.start();
//        t2.start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(2);
//            }
//        }).start();
//
//
//        System.out.println(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(" "+ i);
        }
    }
}

//class MyRunnableClass implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(" " + i);
//            }
//        }
//}

