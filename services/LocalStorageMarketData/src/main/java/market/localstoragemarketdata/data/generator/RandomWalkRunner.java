package market.localstoragemarketdata.data.generator;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.database.storage.FinancialDataStorage;

@Slf4j
public class RandomWalkRunner {

    RandomWalkGeneratorScheduler randomWalkGeneratorScheduler;
    FinancialDataStorage financialDataStorage;

    public RandomWalkRunner(FinancialDataStorage financialDataStorage) {
        this.financialDataStorage = financialDataStorage;
        randomWalkGeneratorScheduler = new RandomWalkGeneratorScheduler(financialDataStorage);
        start();
    }

    void start() {
        log.info("[LocalStorageMarketData] Random Walk generating stock market data - START");
        Thread thread = new Thread(randomWalkGeneratorScheduler::timeBoundedRandomWalk);
        thread.setName("Thread-RandomWalk");
        thread.start();
    };
}
