package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table03;
import core.api.generate.springapigenerate.repository.Table03Repo;
import core.api.generate.springapigenerate.service.Table03Service;
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

@Service("table03Service")
public class Table03ServiceImpl implements Table03Service {

    static final Logger logger = Logger.getLogger(Table03ServiceImpl.class);

    @Autowired
    private Table03Repo table03Repository;

    @Override
    public Table03 createOrUpdateTable03(Table03 table03) {
         Optional<Table03> table03Optional = table03Repository.findById(table03.getId());
         if(table03Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table03 newTable03 = modelMapper.map(table03, Table03.class);
             newTable03 = table03Repository.save(newTable03);
             return newTable03;
         } else {
             table03 = table03Repository.save(table03);
             return table03;
         }
    }

    @Override
    public void deleteTable03ById(Long id) throws EntityNotFoundException {
         Optional<Table03> table03Optional = table03Repository.findById(id);
         if(table03Optional.isPresent())
         {
            table03Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table03 record exist for given id");
         }
    }

    @Override
    public Table03 getTable03ById(Long id) throws EntityNotFoundException {
         Optional<Table03> table03Optional = table03Repository.findById(id);
         if(table03Optional.isPresent())
         {
            return table03Optional.get();
         } else {
            throw new EntityNotFoundException("No Table03 record exist for given id");
         }
    }

    @Override
    public List<Table03> findAll() {
        List<Table03> list = StreamSupport
                .stream(table03Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table03>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table03> table03List = this.findAll();
             apiResponse.setData(table03List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table03 table03) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table03 == null) {
                throw new NullPointerException("Table03 cannot be null");
            }
            else {
                long max = 0;
                long count = table03Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table03Repository.max();
                }
                table03.setId(max);
            }
            Optional<Table03> table03Optional = table03Repository.findById(table03.getId());
            if(table03Optional.isPresent()) {
                throw new EntityExistsException("There is a Table03 record exist for given id");
            } else {
                this.createOrUpdateTable03(table03);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table03 table03) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table03 == null) {
                throw new NullPointerException("table03 cannot be null");
            }
            this.createOrUpdateTable03(table03);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table03> table03List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table03List.size() < 1) {
                throw new NullPointerException("table03 cannot be null");
            }
            for (Table03 obj : table03List) {
                this.deleteTable03ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table03 table03) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable03ById(table03.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 