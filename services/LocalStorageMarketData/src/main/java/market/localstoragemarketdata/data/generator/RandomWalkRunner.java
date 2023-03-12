package market.localstoragemarketdata.data.generator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomWalkRunner {

    RandomWalkGeneratorScheduler randomWalkGeneratorScheduler;

    public RandomWalkRunner() {
        randomWalkGeneratorScheduler = new RandomWalkGeneratorScheduler();
        start();
    }

    void start() {
        log.info("[LocalStorageMarketData] Random Walk generating stock market data - START");
        Thread thread = new Thread(randomWalkGeneratorScheduler::timeBoundedRandomWalk);
        thread.setName("Thread-RandomWalk");
        thread.start();
    };
}
