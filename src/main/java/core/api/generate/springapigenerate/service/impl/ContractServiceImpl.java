package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Contract;
import core.api.generate.springapigenerate.repository.ContractRepo;
import core.api.generate.springapigenerate.service.ContractService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.List;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

    static final Logger logger = Logger.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractRepo contractRepository;

    @Override
    public Contract createOrUpdateContract(Contract contract) {
         Optional<Contract> contractOptional = contractRepository.findById(contract.getId());
         if(contractOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Contract newContract = modelMapper.map(contract, Contract.class);
             newContract = contractRepository.save(newContract);
             return newContract;
         } else {
             contract = contractRepository.save(contract);
             return contract;
         }
    }

    @Override
    public void deleteContractById(Long id) throws EntityNotFoundException {
         Optional<Contract> contractOptional = contractRepository.findById(id);
         if(contractOptional.isPresent())
         {
            contractRepository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Contract record exist for given id");
         }
    }

    @Override
    public Contract getContractById(Long id) throws EntityNotFoundException {
         Optional<Contract> contractOptional = contractRepository.findById(id);
         if(contractOptional.isPresent())
         {
            return contractOptional.get();
         } else {
            throw new EntityNotFoundException("No Contract record exist for given id");
         }
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> list = StreamSupport
                .stream(contractRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Contract>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Contract> contractList = this.findAll();
             apiResponse.setData(contractList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Contract contract) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (contract == null) {
                throw new NullPointerException("Contract cannot be null");
            }
            else {
                long max = 0;
                long count = contractRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = contractRepository.max();
                }
                contract.setId(max);
            }
            Optional<Contract> contractOptional = contractRepository.findById(contract.getId());
            if(contractOptional.isPresent()) {
                throw new EntityExistsException("There is a Contract record exist for given id");
            } else {
                this.createOrUpdateContract(contract);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Contract contract) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (contract == null) {
                throw new NullPointerException("contract cannot be null");
            }
            this.createOrUpdateContract(contract);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Contract> contractList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (contractList.size() < 1) {
                throw new NullPointerException("contract cannot be null");
            }
            for (Contract obj : contractList) {
                this.deleteContractById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Contract contract) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getContractById(contract.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 