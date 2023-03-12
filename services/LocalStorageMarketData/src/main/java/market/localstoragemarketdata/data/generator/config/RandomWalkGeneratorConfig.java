package market.localstoragemarketdata.data.generator.config;

import market.localstoragemarketdata.data.generator.RandomWalkRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomWalkGeneratorConfig {

    @Bean
    RandomWalkRunner randomWalkRunner() {
        return new RandomWalkRunner();
    }
}
