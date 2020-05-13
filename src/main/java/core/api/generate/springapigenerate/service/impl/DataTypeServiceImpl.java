package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.DataType;
import core.api.generate.springapigenerate.repository.DataTypeRepo;
import core.api.generate.springapigenerate.service.DataTypeService;
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

@Service("dataTypeService")
public class DataTypeServiceImpl implements DataTypeService {

    static final Logger logger = Logger.getLogger(DataTypeServiceImpl.class);

    @Autowired
    private DataTypeRepo dataTypeRepository;

    @Override
    public DataType createOrUpdateDataType(DataType dataType) {
         Optional<DataType> dataTypeOptional = dataTypeRepository.findById(dataType.getColumnLong());
         if(dataTypeOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             DataType newDataType = modelMapper.map(dataType, DataType.class);
             newDataType = dataTypeRepository.save(newDataType);
             return newDataType;
         } else {
             dataType = dataTypeRepository.save(dataType);
             return dataType;
         }
    }

    @Override
    public void deleteDataTypeById(Long columnLong) throws EntityNotFoundException {
         Optional<DataType> dataTypeOptional = dataTypeRepository.findById(columnLong);
         if(dataTypeOptional.isPresent())
         {
            dataTypeRepository.deleteById(columnLong);
         } else {
            throw new EntityNotFoundException("No DataType record exist for given id");
         }
    }

    @Override
    public DataType getDataTypeById(Long columnLong) throws EntityNotFoundException {
         Optional<DataType> dataTypeOptional = dataTypeRepository.findById(columnLong);
         if(dataTypeOptional.isPresent())
         {
            return dataTypeOptional.get();
         } else {
            throw new EntityNotFoundException("No DataType record exist for given id");
         }
    }

    @Override
    public List<DataType> findAll() {
        List<DataType> list = StreamSupport
                .stream(dataTypeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<DataType>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<DataType> dataTypeList = this.findAll();
             apiResponse.setData(dataTypeList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(DataType dataType) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (dataType == null) {
                throw new NullPointerException("DataType cannot be null");
            }
            else {
                long max = 0;
                long count = dataTypeRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = dataTypeRepository.max();
                }
                dataType.setColumnLong(max);
            }
            Optional<DataType> dataTypeOptional = dataTypeRepository.findById(dataType.getColumnLong());
            if(dataTypeOptional.isPresent()) {
                throw new EntityExistsException("There is a DataType record exist for given columnLong");
            } else {
                this.createOrUpdateDataType(dataType);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(DataType dataType) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (dataType == null) {
                throw new NullPointerException("dataType cannot be null");
            }
            this.createOrUpdateDataType(dataType);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<DataType> dataTypeList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (dataTypeList.size() < 1) {
                throw new NullPointerException("dataType cannot be null");
            }
            for (DataType obj : dataTypeList) {
                this.deleteDataTypeById(obj.getColumnLong());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(DataType dataType) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getDataTypeById(dataType.getColumnLong()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 