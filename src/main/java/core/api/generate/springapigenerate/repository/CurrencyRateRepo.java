package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepo extends JpaRepository<CurrencyRate, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM CurrencyRate")
    long max();

} 