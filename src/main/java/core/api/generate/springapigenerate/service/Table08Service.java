package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table08;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table08Service {

    Table08 createOrUpdateTable08(Table08 table08);

    void deleteTable08ById(Long id) throws EntityNotFoundException;

    Table08 getTable08ById(Long id) throws EntityNotFoundException;

    List<Table08> findAll();

    ApiResponse<List<Table08>> doView();

    ApiResponse doAdd(Table08 table08);

    ApiResponse doEdit(Table08 table08);

    ApiResponse doDelete(List<Table08> table08List);

    ApiResponse doPreview(Table08 table08);

} 