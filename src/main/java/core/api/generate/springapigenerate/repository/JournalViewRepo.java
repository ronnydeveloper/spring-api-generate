package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.JournalView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalViewRepo extends JpaRepository<JournalView, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM JournalView")
    long max();

} 