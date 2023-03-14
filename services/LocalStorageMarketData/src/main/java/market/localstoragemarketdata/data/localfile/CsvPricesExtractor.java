package market.localstoragemarketdata.data.localfile;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.LocalStorageService;
import market.localstoragemarketdata.data.prices.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.IOException;
import java.util.Scanner;

@Slf4j
public class CsvPricesExtractor {

    public void getPrices() {
        LocalStorageService localStorageService = new LocalStorageService();
        Resource resource = new ClassPathResource("dataset/GOOG_MAX.csv");

        try (Scanner scanner = new Scanner(resource.getFile())) {
            int iterator = 0;
            while (scanner.hasNext()) {
                String next = scanner.next();
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

                    Date date = new Date();
                    date.setDate(split[0], true);

                    Open open = new Open();
                    open.setPrice(Double.parseDouble(split[1]));

                    High high = new High();
                    high.setPrice(Double.parseDouble(split[2]));

                    Low low = new Low();
                    low.setPrice(Double.parseDouble(split[3]));

                    Close close = new Close();
                    close.setPrice(Double.parseDouble(split[4]));

                    localStorageService.putPriceToLocalStorage(date, open, close, high, low);

                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    log.info(e.getMessage());
                }
                iterator++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
