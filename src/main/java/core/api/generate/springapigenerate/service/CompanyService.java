package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Company;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CompanyService {

    Company createOrUpdateCompany(Company company);

    void deleteCompanyById(Long id) throws EntityNotFoundException;

    Company getCompanyById(Long id) throws EntityNotFoundException;

    List<Company> findAll();

    ApiResponse<List<Company>> doView();

    ApiResponse doAdd(Company company);

    ApiResponse doEdit(Company company);

    ApiResponse doDelete(List<Company> companyList);

    ApiResponse doPreview(Company company);

} 