package market.localstoragemarketdata.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    Long id;
    @Column
    LocalDateTime date;
    @Column
    String open;
    @Column
    String close;
    @Column
    String low;
    @Column
    String high;

}
