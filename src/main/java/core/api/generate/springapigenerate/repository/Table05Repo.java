package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table05Repo extends JpaRepository<Table05, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table05")
    long max();

} 