package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table07;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table07Service {

    Table07 createOrUpdateTable07(Table07 table07);

    void deleteTable07ById(Long id) throws EntityNotFoundException;

    Table07 getTable07ById(Long id) throws EntityNotFoundException;

    List<Table07> findAll();

    ApiResponse<List<Table07>> doView();

    ApiResponse doAdd(Table07 table07);

    ApiResponse doEdit(Table07 table07);

    ApiResponse doDelete(List<Table07> table07List);

    ApiResponse doPreview(Table07 table07);

} 