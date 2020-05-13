package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table02;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table02Service {

    Table02 createOrUpdateTable02(Table02 table02);

    void deleteTable02ById(Long id) throws EntityNotFoundException;

    Table02 getTable02ById(Long id) throws EntityNotFoundException;

    List<Table02> findAll();

    ApiResponse<List<Table02>> doView();

    ApiResponse doAdd(Table02 table02);

    ApiResponse doEdit(Table02 table02);

    ApiResponse doDelete(List<Table02> table02List);

    ApiResponse doPreview(Table02 table02);

} 