package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepo extends JpaRepository<Partner, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Partner")
    long max();

} 