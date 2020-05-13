package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table04;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table04Repo extends JpaRepository<Table04, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table04")
    long max();

} 