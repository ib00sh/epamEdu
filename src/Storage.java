public class Storage {
    private int product = 0;

    public synchronized void get() {
        while (product < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }
}


class Product implements Runnable{
    Storage storage;

    public Product(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            storage.put();

        }
    }
}

class Customer implements Runnable{
    Storage storage;

    public Customer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run(){
        for (int i = 0; i < 6; i++) {
            storage.get();
        }
    }
}


class MainClassStore {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Product product = new Product(storage);
        Customer customer = new Customer(storage);

        new Thread(product).start();
        new Thread(customer).start();


    }
}