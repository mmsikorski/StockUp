package market.localstoragemarketdata.data.generator;

import java.time.LocalDateTime;

public interface RandomWalkGenerator {
    RandomWalkRunner start();
    float generateRandomValue();
    LocalDateTime generateRandomLocalDatetime();
    float generateRandomValueAroundTick();
    void loadDataToInMemoryStorage(LocalDateTime date, float value);
    float getPreviousValueFromLocalStorage();
}
