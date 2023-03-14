package market.localstoragemarketdata.database.storage;

import market.localstoragemarketdata.database.entity.FinancialDataEntity;
import market.localstoragemarketdata.database.repo.FinancialDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class FinancialDataStorage {

    final
    FinancialDataRepo financialDataRepo;
    final
    FinancialDataMapper financialDataMapper;

    public FinancialDataStorage(FinancialDataRepo financialDataRepo, FinancialDataMapper financialDataMapper) {
        this.financialDataRepo = financialDataRepo;
        this.financialDataMapper = financialDataMapper;
    }

    public void save(LocalDateTime date, Double open, Double close, Double low, Double high) {
        FinancialDataEntity financialDataEntity = financialDataMapper.toEntity(date, open, close, low, high);
        financialDataRepo.save(financialDataEntity);
    }

    //TODO: Kontroler do wyciągania danych z bazy

}
