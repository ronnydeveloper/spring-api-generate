package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.DataType;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface DataTypeService {

    DataType createOrUpdateDataType(DataType dataType);

    void deleteDataTypeById(Long columnLong) throws EntityNotFoundException;

    DataType getDataTypeById(Long columnLong) throws EntityNotFoundException;

    List<DataType> findAll();

    ApiResponse<List<DataType>> doView();

    ApiResponse doAdd(DataType dataType);

    ApiResponse doEdit(DataType dataType);

    ApiResponse doDelete(List<DataType> dataTypeList);

    ApiResponse doPreview(DataType dataType);

} 