package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Table08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table08Repo extends JpaRepository<Table08, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Table08")
    long max();

} 