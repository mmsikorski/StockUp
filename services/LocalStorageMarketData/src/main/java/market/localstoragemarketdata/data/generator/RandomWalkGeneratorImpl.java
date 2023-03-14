package market.localstoragemarketdata.data.generator;

import market.localstoragemarketdata.data.LocalStorageRandomWalkService;
import market.localstoragemarketdata.data.prices.Mean;
import market.localstoragemarketdata.database.storage.FinancialDataStorage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class RandomWalkGeneratorImpl implements RandomWalkGenerator {

    private final Random random;
    private final FinancialDataStorage storage;
    private float initMeanValue;
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

        double randomValue = 10.0*random.nextGaussian(0, 1);
        float finalRandomValue = Float.parseFloat(String.valueOf(randomValue));
        initMeanValue = initMeanValue + finalRandomValue < 0 || initMeanValue + finalRandomValue > 2500 ? initMeanValue : initMeanValue + finalRandomValue;

        return initMeanValue;
    }

    @Override
    public float generateRandomValueAroundTick() {
        return 0;
    }

    @Override
    public void loadDataToInMemoryStorage(LocalDateTime date, List<Double> value) {
        String price = String.valueOf(value);
        Mean mean = new Mean();
        mean.setPrice(price);
        String stringValue = String.valueOf(value);
//        String dateString = date.toString();

        storage.save(date, value.get(0), stringValue, stringValue, stringValue);


        localStorageRandomWalkService.loadMeanRandomValueToLocalStorage(date, mean);
    }


    @Override
    public float getPreviousValueFromLocalStorage() {

        return 0;
    }
}
