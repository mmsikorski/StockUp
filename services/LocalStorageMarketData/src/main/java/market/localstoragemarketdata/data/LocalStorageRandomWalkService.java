package market.localstoragemarketdata.data;

import market.localstoragemarketdata.data.prices.Mean;

import java.time.LocalDateTime;

public class LocalStorageRandomWalkService {

    public void loadMeanRandomValueToLocalStorage(LocalDateTime date, Mean mean) {
        LocalStorage.meanRandomPrice.put(date, mean);
    }
}
