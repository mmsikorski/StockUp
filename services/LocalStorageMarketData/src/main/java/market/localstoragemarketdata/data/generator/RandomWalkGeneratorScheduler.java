package market.localstoragemarketdata.data.generator;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.LocalStorage;
import market.localstoragemarketdata.database.storage.FinancialDataStorage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
public class RandomWalkGeneratorScheduler {
    public static int MAX_TIME_DISTANCE_BETWEEN_TICKS = 1500;
    public static int MIN_TIME_DISTANCE_BETWEEN_TICKS = 100;

    public RandomWalkGenerator randomWalkGenerator;
    public Random random;

    public RandomWalkGeneratorScheduler(FinancialDataStorage financialDataStorage) {
        randomWalkGenerator = new RandomWalkGeneratorImpl(financialDataStorage);
        random = new Random();
    }

    public void timeBoundedRandomWalk() {
        long timeMillis = System.currentTimeMillis();
        long randomTimeDistance = random.nextInt(MIN_TIME_DISTANCE_BETWEEN_TICKS, MAX_TIME_DISTANCE_BETWEEN_TICKS);
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();

            if ( (currentTimeMillis - timeMillis) > randomTimeDistance ) {

                timeMillis = System.currentTimeMillis();
                randomTimeDistance = random.nextInt(MIN_TIME_DISTANCE_BETWEEN_TICKS, MAX_TIME_DISTANCE_BETWEEN_TICKS);


                double value = randomWalkGenerator.generateRandomValue();
                LocalDateTime date = randomWalkGenerator.generateRandomLocalDatetime();
                randomWalkGenerator.loadDataToInMemoryStorage(date, value);

                log.info("[LocalStorageMarketData] RandomWalk: date = {}, value = {}, size = {} , MB size = {} ", date, value, LocalStorage.meanRandomPrice.size());
            }
        }
    }

}
