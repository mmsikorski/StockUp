package market.localstoragemarketdata.data.config;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.data.StorageRunner;
import market.localstoragemarketdata.data.localfile.CsvPricesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StorageConfig {

    @Bean
    StorageRunner fulfillStorage() {
        log.info("Loading data to storage");
        StorageRunner storageRunner = new StorageRunner();
        log.info("Data to storage are loaded");
        return storageRunner;
    }
}
