package main.java;

import java.util.concurrent.Semaphore;

public class Solution_1226 {
    Semaphore[] locks = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0)
    };

    public void DiningPhilosophers() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        locks[philosopher].acquire(1);
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[(philosopher + 1) % 5].release(1);
    }
}
