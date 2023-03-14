package market.localstoragemarketdata.data.generator;

import java.time.LocalDateTime;

public interface RandomWalkGenerator {
    RandomWalkRunner start();
    double generateRandomValue();
    LocalDateTime generateRandomLocalDatetime();
    float generateRandomValueAroundTick();
    void loadDataToInMemoryStorage(LocalDateTime date, double value);
    float getPreviousValueFromLocalStorage();
}
