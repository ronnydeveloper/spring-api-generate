package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.CurrencyRate;
import core.api.generate.springapigenerate.repository.CurrencyRateRepo;
import core.api.generate.springapigenerate.service.CurrencyRateService;
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

@Service("currencyRateService")
public class CurrencyRateServiceImpl implements CurrencyRateService {

    static final Logger logger = Logger.getLogger(CurrencyRateServiceImpl.class);

    @Autowired
    private CurrencyRateRepo currencyRateRepository;

    @Override
    public CurrencyRate createOrUpdateCurrencyRate(CurrencyRate currencyRate) {
         Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findById(currencyRate.getId());
         if(currencyRateOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             CurrencyRate newCurrencyRate = modelMapper.map(currencyRate, CurrencyRate.class);
             newCurrencyRate = currencyRateRepository.save(newCurrencyRate);
             return newCurrencyRate;
         } else {
             currencyRate = currencyRateRepository.save(currencyRate);
             return currencyRate;
         }
    }

    @Override
    public void deleteCurrencyRateById(Long id) throws EntityNotFoundException {
         Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findById(id);
         if(currencyRateOptional.isPresent())
         {
            currencyRateRepository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No CurrencyRate record exist for given id");
         }
    }

    @Override
    public CurrencyRate getCurrencyRateById(Long id) throws EntityNotFoundException {
         Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findById(id);
         if(currencyRateOptional.isPresent())
         {
            return currencyRateOptional.get();
         } else {
            throw new EntityNotFoundException("No CurrencyRate record exist for given id");
         }
    }

    @Override
    public List<CurrencyRate> findAll() {
        List<CurrencyRate> list = StreamSupport
                .stream(currencyRateRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<CurrencyRate>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<CurrencyRate> currencyRateList = this.findAll();
             apiResponse.setData(currencyRateList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(CurrencyRate currencyRate) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (currencyRate == null) {
                throw new NullPointerException("CurrencyRate cannot be null");
            }
            else {
                long max = 0;
                long count = currencyRateRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = currencyRateRepository.max();
                }
                currencyRate.setId(max);
            }
            Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findById(currencyRate.getId());
            if(currencyRateOptional.isPresent()) {
                throw new EntityExistsException("There is a CurrencyRate record exist for given id");
            } else {
                this.createOrUpdateCurrencyRate(currencyRate);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(CurrencyRate currencyRate) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (currencyRate == null) {
                throw new NullPointerException("currencyRate cannot be null");
            }
            this.createOrUpdateCurrencyRate(currencyRate);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<CurrencyRate> currencyRateList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (currencyRateList.size() < 1) {
                throw new NullPointerException("currencyRate cannot be null");
            }
            for (CurrencyRate obj : currencyRateList) {
                this.deleteCurrencyRateById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(CurrencyRate currencyRate) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getCurrencyRateById(currencyRate.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 