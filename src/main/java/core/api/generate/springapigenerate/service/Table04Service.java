package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table04;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table04Service {

    Table04 createOrUpdateTable04(Table04 table04);

    void deleteTable04ById(Long id) throws EntityNotFoundException;

    Table04 getTable04ById(Long id) throws EntityNotFoundException;

    List<Table04> findAll();

    ApiResponse<List<Table04>> doView();

    ApiResponse doAdd(Table04 table04);

    ApiResponse doEdit(Table04 table04);

    ApiResponse doDelete(List<Table04> table04List);

    ApiResponse doPreview(Table04 table04);

} 