package market.app.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import market.app.data.PriceModel;
import market.app.data.PriceModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class DataConsumer {

    @Autowired
    PriceModelMapper priceModelMapper;
    static long countRequests;
    String threadName;
    Thread thread;

    public DataConsumer(String threadName) {
        runConsumerLogic(threadName);
    }

    private void runConsumerLogic(String threadName) {
        countRequests = 0;
        this.thread = new Thread(this::consumerData);
        if (threadName != null) {
            this.threadName = threadName;
            this.thread.setName(threadName);
        }
        thread.start();
    }

    void consumerData() {
        RestTemplate restTemplate = new RestTemplate();
        log.info("[ConsumerStockData] Connecting to data storage docker");
//        String stockDataStorageUrl = "http://172.24.0.2:8070";
//        String url = "http://172.24.0.2:8070/data?minDate=2022-02-02&maxDate=2022-02-09";
//        String url = stockDataStorageUrl + "/data?minDate=2022-02-02&maxDate=2022-02-09";
        String url = "http://localhost:8070/data?minDate=2022-02-02&maxDate=2022-02-09";
        long l = System.currentTimeMillis();
        while (true) {
            long e = System.currentTimeMillis();
            if ( (l - e) % 1000 == 0 ) {
                String response = restTemplate.getForObject(url, String.class);
                try {
                    countRequests++;
                    List<PriceModel> priceModels = priceModelMapper.fromStringToListPrice(response);
                    priceModels.forEach(x -> log.info("[ConsumerStockData] (Thread: {}) | Req: {} | Received data: {}",
                            this.thread.getName() , countRequests , x));
                } catch (JsonProcessingException ex) {
                    log.info("[ConsumerStockData] Error with JsonProcessing" + ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
