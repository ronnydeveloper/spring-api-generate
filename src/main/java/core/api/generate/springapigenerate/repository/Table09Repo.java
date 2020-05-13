package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table09Repo extends JpaRepository<Table09, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table09")
    long max();

} 