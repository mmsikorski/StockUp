package market.localstoragemarketdata.data.localfile;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.LocalStorageService;
import market.localstoragemarketdata.data.prices.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

@Slf4j
public class CsvPricesExtractor {

    public void getPrices() {
        LocalStorageService localStorageService = new LocalStorageService();
        //String path = "/Users/dev/Desktop/dev/ts2vg/datasets/GOOG_MAX.csv";
        //        String path = "/Users/dev/Desktop/dev/market/LocalStorageMarketData/GOOG_MAX.csv";
        String path = "/Users/dev/Desktop/dev/StockUp/services/LocalStorageMarketData/dataset/GOOG_MAX.csv";
//        String path = "/dataset/GOOG_MAX.csv";
        File file = new File(path);

        try {
            Scanner sc = new Scanner(file);
            int iterator = 0;
            while( sc.hasNext() ) {
                String next = sc.next();
                String[] split = next.split(",");
                try {
                    StringBuilder append = new StringBuilder()
                            .append("Date: ")
                            .append(split[0])
                            .append(" | Open: ")
                            .append(split[1])
                            .append(" | High: ")
                            .append(split[2])
                            .append(" | Low: ")
                            .append(split[3])
                            .append(" | Close: ")
                            .append(split[4]);
                    String s = append.toString();
//                    System.out.println(s);

                    Date date = new Date();
                    date.setDate(split[0], true);

                    Open open = new Open();
                    open.setPrice(split[1]);

                    High high = new High();
                    high.setPrice(split[2]);

                    Low low = new Low();
                    low.setPrice(split[3]);

                    Close close = new Close();
                    close.setPrice(split[4]);

                    localStorageService.putPriceToLocalStorage(date, open, close, high, low);

                } catch (IndexOutOfBoundsException e) {
                    log.info(e.getMessage());
                }
//                    System.out.println(iterator);
//                    Arrays.stream(split).forEach(x -> log.info(x));
            }
            iterator++;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
