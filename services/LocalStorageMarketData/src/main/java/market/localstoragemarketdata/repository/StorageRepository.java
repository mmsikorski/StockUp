package market.localstoragemarketdata.repository;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.LocalStorage;
import market.localstoragemarketdata.data.prices.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class StorageRepository {

    public int getStorageInfo() {
        int size = LocalStorage.closePrices.keySet().size();
        return size;
    }

    public List<RequestData> getDataFromMinDateToMaxDate(String minDate, String maxDate) {
        List<Date> collect = LocalStorage.lowPrices.keySet().stream()
                .filter(x -> {
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate minLocalDate = LocalDate.parse(minDate, format);
                    LocalDate maxLocalDate = LocalDate.parse(maxDate, format);
                    LocalDate date = x.getLocalDate();
                    if (date == null) {
                        log.info("[LocalStorageMarketData] for x = " + x + " date = x.getLocalDate(); is null");
                        return false;
                    }
                    boolean after = date.isAfter(minLocalDate);
                    boolean before = date.isBefore(maxLocalDate);
                    return before && after;
                }).toList();

        return collect.stream().map(x -> {
            double open = LocalStorage.openPrices.get(x).getPrice();
            double close = LocalStorage.closePrices.get(x).getPrice();
            double high = LocalStorage.highPrices.get(x).getPrice();
            double low = LocalStorage.lowPrices.get(x).getPrice();
            return new RequestData(x.getDate(), open, close, low, high);
        }).toList();
    }
}
