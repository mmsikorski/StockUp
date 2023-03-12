package market.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumerStockDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStockDataApplication.class, args);
    }

}
