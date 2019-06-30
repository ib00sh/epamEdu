public class MainThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
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