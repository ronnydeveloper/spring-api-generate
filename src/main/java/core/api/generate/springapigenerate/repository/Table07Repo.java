package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table07Repo extends JpaRepository<Table07, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table07")
    long max();

} 