package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table10;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table10Service {

    Table10 createOrUpdateTable10(Table10 table10);

    void deleteTable10ById(Long id) throws EntityNotFoundException;

    Table10 getTable10ById(Long id) throws EntityNotFoundException;

    List<Table10> findAll();

    ApiResponse<List<Table10>> doView();

    ApiResponse doAdd(Table10 table10);

    ApiResponse doEdit(Table10 table10);

    ApiResponse doDelete(List<Table10> table10List);

    ApiResponse doPreview(Table10 table10);

} 