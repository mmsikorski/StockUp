package market.localstoragemarketdata.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "financial_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    Long id;
    @Column(name = "date")
    LocalDateTime date;
    @Column(name = "open")
    Double open;
    @Column(name = "close")
    Double close;
    @Column(name = "low")
    Double low;
    @Column(name = "high")
    Double high;

}
