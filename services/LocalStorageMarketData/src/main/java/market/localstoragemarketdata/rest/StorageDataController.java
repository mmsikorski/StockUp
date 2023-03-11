package market.localstoragemarketdata.rest;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.repository.RequestData;
import market.localstoragemarketdata.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class StorageDataController {

    @Autowired
    StorageRepository storageRepository;

    @GetMapping("/data")
    @ResponseBody
    List<RequestData> getData(@RequestParam String minDate, @RequestParam String maxDate) {
        log.info("[LocalStorageMarketData] Collecting data for min and max date: " + minDate + " | " + maxDate);
        List<RequestData> dataFromDateToDate = storageRepository.getDataFromMinDateToMaxDate(minDate, maxDate);
        log.info("[LocalStorageMarketData] Collected data (first five results: {}", dataFromDateToDate.stream().limit(5).collect(Collectors.toList()));
        log.info("[LocalStorageMarketData] All collected data {}", dataFromDateToDate.size());
        return dataFromDateToDate;
    }
}
