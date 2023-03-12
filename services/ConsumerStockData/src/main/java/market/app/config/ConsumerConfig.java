package market.app.config;

import market.app.consumer.DataConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    @Bean
    DataConsumer dataConsumer1() {
        return new DataConsumer("Thread-1");
    }

    @Bean
    DataConsumer dataConsumer2() {
        return new DataConsumer("Thread-2");
    }

    @Bean
    DataConsumer dataConsumer3() {
        return new DataConsumer("Thread-3");
    }

    @Bean
    DataConsumer dataConsumer4() {
        return new DataConsumer("Thread-4");
    }

    @Bean
    DataConsumer dataConsumer5() {
        return new DataConsumer("Thread-5");
    }
}
