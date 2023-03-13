package market.localstoragemarketdata.database.storage;

import market.localstoragemarketdata.database.entity.FinancialDataEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FinancialDataMapper {

    FinancialDataEntity toEntity(LocalDateTime date, String open, String close, String low, String high) {
        FinancialDataEntity.FinancialDataEntityBuilder builder = FinancialDataEntity.builder();


        return builder
                .low(low)
                .high(high)
                .close(close)
                .open(open)
                .date(date)
                .build();
    }
}
