package market.localstoragemarketdata.rest;

import market.localstoragemarketdata.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageInfoController {

    @Autowired
    StorageRepository storageRepository;

    @GetMapping("/storage/info")
    String getInfo() {
        int storageInfo = storageRepository.getStorageInfo();
        return "Size of storage is " + storageInfo;
    }
}
