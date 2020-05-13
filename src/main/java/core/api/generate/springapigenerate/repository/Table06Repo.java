package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table06Repo extends JpaRepository<Table06, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table06")
    long max();

} 