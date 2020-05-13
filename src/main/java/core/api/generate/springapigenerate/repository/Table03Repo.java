package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table03Repo extends JpaRepository<Table03, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table03")
    long max();

} 