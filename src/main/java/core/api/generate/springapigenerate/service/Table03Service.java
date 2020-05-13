package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table03;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table03Service {

    Table03 createOrUpdateTable03(Table03 table03);

    void deleteTable03ById(Long id) throws EntityNotFoundException;

    Table03 getTable03ById(Long id) throws EntityNotFoundException;

    List<Table03> findAll();

    ApiResponse<List<Table03>> doView();

    ApiResponse doAdd(Table03 table03);

    ApiResponse doEdit(Table03 table03);

    ApiResponse doDelete(List<Table03> table03List);

    ApiResponse doPreview(Table03 table03);

} 