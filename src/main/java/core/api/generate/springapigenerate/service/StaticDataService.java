package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.StaticData;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface StaticDataService {

    StaticData createOrUpdateStaticData(StaticData staticData);

    void deleteStaticDataById(Long id) throws EntityNotFoundException;

    StaticData getStaticDataById(Long id) throws EntityNotFoundException;

    List<StaticData> findAll();

    ApiResponse<List<StaticData>> doView();

    ApiResponse doAdd(StaticData staticData);

    ApiResponse doEdit(StaticData staticData);

    ApiResponse doDelete(List<StaticData> staticDataList);

    ApiResponse doPreview(StaticData staticData);

} 