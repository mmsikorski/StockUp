package market.localstoragemarketdata.data;

import market.localstoragemarketdata.data.prices.*;

public class LocalStorageService {

    public void putPriceToLocalStorage(Date date, Open open, Close close, High high, Low low) {
        LocalStorage.openPrices.put(date, open);
        LocalStorage.lowPrices.put(date, low);
        LocalStorage.highPrices.put(date, high);
        LocalStorage.closePrices.put(date, close);
    }

}
