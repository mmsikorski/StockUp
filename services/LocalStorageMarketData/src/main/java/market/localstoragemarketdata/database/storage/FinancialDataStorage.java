package market.localstoragemarketdata.database.storage;

import market.localstoragemarketdata.database.entity.FinancialDataEntity;
import market.localstoragemarketdata.database.repo.FinancialDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FinancialDataStorage {

    @Autowired
    FinancialDataRepo financialDataRepo;
    @Autowired
    FinancialDataMapper financialDataMapper;

    public void save(LocalDateTime date, String open, String close, String low, String high) {
        FinancialDataEntity financialDataEntity = financialDataMapper.toEntity(date, open, close, low, high);
        financialDataRepo.save(financialDataEntity);
    }

}
