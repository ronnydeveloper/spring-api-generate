package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.StaticData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticDataRepo extends JpaRepository<StaticData, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM StaticData")
    long max();

} 