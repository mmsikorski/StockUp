package market.localstoragemarketdata.database.storage;

import market.localstoragemarketdata.database.entity.FinancialDataEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class FinancialDataMapper {

    FinancialDataEntity toEntity(LocalDateTime date, Double open, Double close, Double low, Double high) {
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
