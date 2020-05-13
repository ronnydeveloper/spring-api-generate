package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table02Repo extends JpaRepository<Table02, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table02")
    long max();

} 