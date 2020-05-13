package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Query(value = "SELECT (max(id) + 1) as max FROM Account")
    long max();

} 