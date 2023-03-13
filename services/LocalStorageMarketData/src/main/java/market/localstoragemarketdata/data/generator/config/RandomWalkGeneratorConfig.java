package market.localstoragemarketdata.data.generator.config;

import market.localstoragemarketdata.data.generator.RandomWalkRunner;
import market.localstoragemarketdata.database.storage.FinancialDataStorage;
import market.localstoragemarketdata.repository.StorageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomWalkGeneratorConfig {

    @Bean
    RandomWalkRunner randomWalkRunner(FinancialDataStorage financialDataStorage) {
        return new RandomWalkRunner(financialDataStorage);
    }
}
