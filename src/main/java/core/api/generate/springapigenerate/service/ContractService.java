package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Contract;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ContractService {

    Contract createOrUpdateContract(Contract contract);

    void deleteContractById(Long id) throws EntityNotFoundException;

    Contract getContractById(Long id) throws EntityNotFoundException;

    List<Contract> findAll();

    ApiResponse<List<Contract>> doView();

    ApiResponse doAdd(Contract contract);

    ApiResponse doEdit(Contract contract);

    ApiResponse doDelete(List<Contract> contractList);

    ApiResponse doPreview(Contract contract);

} 