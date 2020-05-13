package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table09;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table09Service {

    Table09 createOrUpdateTable09(Table09 table09);

    void deleteTable09ById(Long id) throws EntityNotFoundException;

    Table09 getTable09ById(Long id) throws EntityNotFoundException;

    List<Table09> findAll();

    ApiResponse<List<Table09>> doView();

    ApiResponse doAdd(Table09 table09);

    ApiResponse doEdit(Table09 table09);

    ApiResponse doDelete(List<Table09> table09List);

    ApiResponse doPreview(Table09 table09);

} 