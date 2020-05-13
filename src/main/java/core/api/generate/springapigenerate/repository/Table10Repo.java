package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table10Repo extends JpaRepository<Table10, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table10")
    long max();

} 