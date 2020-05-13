package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table01Repo extends JpaRepository<Table01, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table01")
    long max();

} 