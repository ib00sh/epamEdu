public class MainDeamon {
    public static void main(String[] args) {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int seconds = 0;
                while (true){
                    seconds++;
                    System.out.println("time is: " + seconds);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timer.setDaemon(true);
        timer.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
