package market.localstoragemarketdata.data.generator;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.LocalStorage;

import java.lang.instrument.Instrumentation;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
public class RandomWalkGeneratorScheduler {
    public static int MAX_TIME_DISTANCE_BETWEEN_TICKS = 2000;
    public RandomWalkGenerator randomWalkGenerator;
    public Random random;

    public RandomWalkGeneratorScheduler() {
        randomWalkGenerator = new RandomWalkGeneratorImpl();
        random = new Random();
    }

    public void timeBoundedRandomWalk() {
        long timeMillis = System.currentTimeMillis();
        long randomTimeDistance = random.nextInt(100, MAX_TIME_DISTANCE_BETWEEN_TICKS);
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();

            if ( (currentTimeMillis - timeMillis) > randomTimeDistance ) {

                timeMillis = System.currentTimeMillis();
                randomTimeDistance = random.nextInt(100, MAX_TIME_DISTANCE_BETWEEN_TICKS);


                float value = randomWalkGenerator.generateRandomValue();
                LocalDateTime date = randomWalkGenerator.generateRandomLocalDatetime();
                randomWalkGenerator.loadDataToInMemoryStorage(date, value);
                log.info("[LocalStorageMarketData] RandomWalk: date = {}, value = {}, size = {}", date, value, LocalStorage.meanRandomPrice.size());
            }
        }
    }
}
