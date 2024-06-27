package org.example.java2706;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        WareHouse wareHouse = new WareHouse(market);
        Store store = new Store(market);

        Thread p_Thread = new Thread(producer);
        Thread w_Thread = new Thread(wareHouse);
        Thread s_Thread = new Thread(store);
        Thread c_Thread = new Thread(consumer);


        p_Thread.start();
        w_Thread.start();
        s_Thread.start();
        c_Thread.start();

        p_Thread.join();
        w_Thread.join();
        s_Thread.join();
        c_Thread.join();
    }
}

class Market {
    private final Object LOCK = new Object();
    private int breadCounter = 0;
    private boolean producerTurn = true;
    private boolean warehouseTurn = false;
    private boolean storeTurn = false;
    private boolean consumerTurn = false;

    public void produceBread() {
        synchronized (LOCK) {
            while (!producerTurn && breadCounter >= 5) {
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
            breadCounter++;
            System.out.println("Producer: " + breadCounter);
            LOCK.notifyAll();
        }
        producerTurn = false;
        warehouseTurn = true;
    }

    public void takenToTheWarehouse() {
        synchronized (LOCK) {
            while (!warehouseTurn && breadCounter < 1) {
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
            breadCounter--;
            System.out.println("WareHouse: " + breadCounter);
            LOCK.notifyAll();
        }
        warehouseTurn = false;
        storeTurn = true;
    }

    public void storeDelivery() {
        synchronized (LOCK) {
            while (!storeTurn && breadCounter >= 5) {
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
            breadCounter++;
            System.out.println("Store: " + breadCounter);
            LOCK.notifyAll();
        }
        storeTurn = false;
        consumerTurn = true;

    }

    public void soldBread() {
        synchronized (LOCK) {
            while (!consumerTurn && breadCounter < 1) {
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
            breadCounter--;
            System.out.println("Consumer: " + breadCounter);
            consumerTurn = false;
            producerTurn = true;
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
        for (int i = 0; i < 20; i++) {
            market.produceBread();
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
        for (int i = 0; i < 20; i++) {
            market.soldBread();
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
        for (int i = 0; i < 20; i++) {
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
        for (int i = 0; i < 20; i++) {
            market.storeDelivery();
        }
    }
}