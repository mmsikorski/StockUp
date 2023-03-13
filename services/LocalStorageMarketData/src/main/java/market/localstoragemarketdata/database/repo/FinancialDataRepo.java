package market.localstoragemarketdata.database.repo;

import market.localstoragemarketdata.database.entity.FinancialDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialDataRepo extends JpaRepository<FinancialDataEntity, Long> {
}
