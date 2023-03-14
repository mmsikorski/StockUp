package market.localstoragemarketdata.data.generator;

import market.localstoragemarketdata.data.LocalStorageRandomWalkService;
import market.localstoragemarketdata.data.prices.Mean;
import market.localstoragemarketdata.database.storage.FinancialDataStorage;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomWalkGeneratorImpl implements RandomWalkGenerator {

    private final Random random;
    private final FinancialDataStorage storage;
    private double initMeanValue;
    private final LocalStorageRandomWalkService localStorageRandomWalkService;

    public RandomWalkGeneratorImpl(FinancialDataStorage financialDataStorage) {
        this.storage = financialDataStorage;
        this.random = new Random();
        this.localStorageRandomWalkService = new LocalStorageRandomWalkService();
        initMeanValue = this.random.nextFloat();
    }

    @Override
    public RandomWalkRunner start() {
        return null;
    }

    @Override
    public double generateRandomValue() {
        return generateRandomValue(0.0F, 0.0F);
    }

    @Override
    public LocalDateTime generateRandomLocalDatetime() {
        return LocalDateTime.now();
    }

    public double generateRandomValue(float mean, float stddev) { //Possible that we will create setters and getters for mean anf stddev
//        float randomValue = random.nextFloat();
//        float unchangedInitMeanValue = initMeanValue;

        double randomValue = 10.0*random.nextGaussian(0, 1);
        initMeanValue = initMeanValue + randomValue < 0 || initMeanValue + randomValue > 2500 ? initMeanValue : initMeanValue + randomValue;

        return initMeanValue;
    }

    @Override
    public float generateRandomValueAroundTick() {
        return 0;
    }

    @Override
    public void loadDataToInMemoryStorage(LocalDateTime date, double value) {
        Mean mean = new Mean();
        mean.setPrice(value);

//        String dateString = date.toString();

        storage.save(date, value, value, value, value);


        localStorageRandomWalkService.loadMeanRandomValueToLocalStorage(date, mean);
    }

    @Override
    public float getPreviousValueFromLocalStorage() {

        return 0;
    }
}
