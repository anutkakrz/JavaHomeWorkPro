
package org.example.java2906;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();

        Producer producer = new Producer(market);
        WareHouse wareHouse = new WareHouse(market);
        Store store = new Store(market);
        Consumer consumer = new Consumer(market);

        Thread pThread = new Thread(producer);
        Thread wThread = new Thread(wareHouse);
        Thread sThread = new Thread(store);
        Thread cThread = new Thread(consumer);

        pThread.start();
        wThread.start();
        sThread.start();
        cThread.start();

        pThread.join();
        wThread.join();
        sThread.join();
        cThread.join();
    }
}

class Market {
    private final Object LOCK = new Object();
    private int breadCounter = 0;
    private int turn = 0; // 0: Producer, 1: Warehouse, 2: Store, 3: Consumer

    public void produceBread() {
        synchronized (LOCK) {
            while (turn != 0) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++) {
                breadCounter++;
                System.out.println("Producer произвел хлеб " + breadCounter);
            }
            System.out.println("В хлебопекарне "+breadCounter+" буханок хлеба");
            turn = 1;
            LOCK.notifyAll();
        }
    }

    public void takenToTheWarehouse() {
        synchronized (LOCK) {
            while (turn != 1) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(123);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5 ; i++) {
                breadCounter--;
                System.out.println("WareHouse погрузили хлеб, чтоб отвезти на склад " + breadCounter);
            }
            System.out.println("Хлеб отвезли на склад, в хлебопекарне осталось:  " + breadCounter+ " буханок хлеба");
            turn = 2;
            LOCK.notifyAll();
        }
    }

    public void storeDelivery() {
        synchronized (LOCK) {
            while (turn != 2) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(234);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++) {
                breadCounter++;
                System.out.println("Хлеб погрузили в машину, чтоб доставить со склада в магазин " + breadCounter);
            }
            System.out.println("Store хлеб доставили со склада в магазин, в магазине:  " + breadCounter+" буханок хлеба");
            turn = 3;
            LOCK.notifyAll();
        }
    }

    public void soldBread() {
        synchronized (LOCK) {
            while (turn != 3) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(123);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++){
                breadCounter--;
                System.out.println("Consumer покупатель купил хлеб " + breadCounter);
            }
            System.out.println("В магазине осталось " + breadCounter+" буханок хлеба");
            turn = 0;
            LOCK.notifyAll();
        }
    }
}

class Producer implements Runnable {
    private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            market.produceBread();
        }
    }
}

class WareHouse implements Runnable {
    private Market market;

    public WareHouse(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            market.takenToTheWarehouse();
        }
    }
}

class Store implements Runnable {
    private Market market;

    public Store(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3 ; i++) {
            market.storeDelivery();
        }
    }
}

class Consumer implements Runnable {
    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            market.soldBread();
        }
    }
}
