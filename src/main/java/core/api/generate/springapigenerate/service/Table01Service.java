package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table01;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table01Service {

    Table01 createOrUpdateTable01(Table01 table01);

    void deleteTable01ById(Long id) throws EntityNotFoundException;

    Table01 getTable01ById(Long id) throws EntityNotFoundException;

    List<Table01> findAll();

    ApiResponse<List<Table01>> doView();

    ApiResponse doAdd(Table01 table01);

    ApiResponse doEdit(Table01 table01);

    ApiResponse doDelete(List<Table01> table01List);

    ApiResponse doPreview(Table01 table01);

} 