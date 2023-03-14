package market.localstoragemarketdata.data.generator;

import java.time.LocalDateTime;
import java.util.List;

public interface RandomWalkGenerator {
    RandomWalkRunner start();
    float generateRandomValue();
    LocalDateTime generateRandomLocalDatetime();
    float generateRandomValueAroundTick();
    void loadDataToInMemoryStorage(LocalDateTime date, List<Double> value);
    float getPreviousValueFromLocalStorage();
}
