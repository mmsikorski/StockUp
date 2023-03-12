package market.localstoragemarketdata.data.generator;

import market.localstoragemarketdata.data.LocalStorageRandomWalkService;
import market.localstoragemarketdata.data.prices.Mean;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomWalkGeneratorImpl implements RandomWalkGenerator {

    private final Random random;
    private float initMeanValue;
    private final LocalStorageRandomWalkService localStorageRandomWalkService;

    public RandomWalkGeneratorImpl() {
        this.random = new Random();
        this.localStorageRandomWalkService = new LocalStorageRandomWalkService();
        initMeanValue = this.random.nextFloat();
    }

    @Override
    public RandomWalkRunner start() {
        return null;
    }

    @Override
    public float generateRandomValue() {
        return generateRandomValue(0.0F, 0.0F);
    }

    @Override
    public LocalDateTime generateRandomLocalDatetime() {
        return LocalDateTime.now();
    }

    public float generateRandomValue(float mean, float stddev) { //Possible that we will create setters and getters for mean anf stddev
//        float randomValue = random.nextFloat();
//        float unchangedInitMeanValue = initMeanValue;

        double randomValue = random.nextGaussian(0, 10);
        float finalRandomValue = Float.parseFloat(String.valueOf(randomValue));
        initMeanValue = initMeanValue + finalRandomValue < 0 ? initMeanValue : initMeanValue + finalRandomValue;
        return initMeanValue;
    }

    @Override
    public float generateRandomValueAroundTick() {
        return 0;
    }

    @Override
    public void loadDataToInMemoryStorage(LocalDateTime date, float value) {
        String price = String.valueOf(value);
        Mean mean = new Mean();
        mean.setPrice(price);
        localStorageRandomWalkService.loadMeanRandomValueToLocalStorage(date, mean);
    }

    @Override
    public float getPreviousValueFromLocalStorage() {

        return 0;
    }
}
