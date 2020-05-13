package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table06;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table06Service {

    Table06 createOrUpdateTable06(Table06 table06);

    void deleteTable06ById(Long id) throws EntityNotFoundException;

    Table06 getTable06ById(Long id) throws EntityNotFoundException;

    List<Table06> findAll();

    ApiResponse<List<Table06>> doView();

    ApiResponse doAdd(Table06 table06);

    ApiResponse doEdit(Table06 table06);

    ApiResponse doDelete(List<Table06> table06List);

    ApiResponse doPreview(Table06 table06);

} 