package core.api.generate.springapigenerate.repository;

import core.api.generate.springapigenerate.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepo extends JpaRepository<DataType, Long> {

    @Query(value = "SELECT (max(columnLong) + 1) as max FROM DataType")
    long max();

} 