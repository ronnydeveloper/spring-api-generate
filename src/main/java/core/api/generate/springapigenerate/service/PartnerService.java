package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Partner;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface PartnerService {

    Partner createOrUpdatePartner(Partner partner);

    void deletePartnerById(Long id) throws EntityNotFoundException;

    Partner getPartnerById(Long id) throws EntityNotFoundException;

    List<Partner> findAll();

    ApiResponse<List<Partner>> doView();

    ApiResponse doAdd(Partner partner);

    ApiResponse doEdit(Partner partner);

    ApiResponse doDelete(List<Partner> partnerList);

    ApiResponse doPreview(Partner partner);

} 