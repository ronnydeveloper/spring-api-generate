package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Table05;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface Table05Service {

    Table05 createOrUpdateTable05(Table05 table05);

    void deleteTable05ById(Long id) throws EntityNotFoundException;

    Table05 getTable05ById(Long id) throws EntityNotFoundException;

    List<Table05> findAll();

    ApiResponse<List<Table05>> doView();

    ApiResponse doAdd(Table05 table05);

    ApiResponse doEdit(Table05 table05);

    ApiResponse doDelete(List<Table05> table05List);

    ApiResponse doPreview(Table05 table05);

} 