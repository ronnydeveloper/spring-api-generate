package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table08;
import core.api.generate.springapigenerate.repository.Table08Repo;
import core.api.generate.springapigenerate.service.Table08Service;
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

@Service("table08Service")
public class Table08ServiceImpl implements Table08Service {

    static final Logger logger = Logger.getLogger(Table08ServiceImpl.class);

    @Autowired
    private Table08Repo table08Repository;

    @Override
    public Table08 createOrUpdateTable08(Table08 table08) {
         Optional<Table08> table08Optional = table08Repository.findById(table08.getId());
         if(table08Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table08 newTable08 = modelMapper.map(table08, Table08.class);
             newTable08 = table08Repository.save(newTable08);
             return newTable08;
         } else {
             table08 = table08Repository.save(table08);
             return table08;
         }
    }

    @Override
    public void deleteTable08ById(Long id) throws EntityNotFoundException {
         Optional<Table08> table08Optional = table08Repository.findById(id);
         if(table08Optional.isPresent())
         {
            table08Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table08 record exist for given id");
         }
    }

    @Override
    public Table08 getTable08ById(Long id) throws EntityNotFoundException {
         Optional<Table08> table08Optional = table08Repository.findById(id);
         if(table08Optional.isPresent())
         {
            return table08Optional.get();
         } else {
            throw new EntityNotFoundException("No Table08 record exist for given id");
         }
    }

    @Override
    public List<Table08> findAll() {
        List<Table08> list = StreamSupport
                .stream(table08Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table08>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table08> table08List = this.findAll();
             apiResponse.setData(table08List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table08 table08) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table08 == null) {
                throw new NullPointerException("Table08 cannot be null");
            }
            else {
                long max = 0;
                long count = table08Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table08Repository.max();
                }
                table08.setId(max);
            }
            Optional<Table08> table08Optional = table08Repository.findById(table08.getId());
            if(table08Optional.isPresent()) {
                throw new EntityExistsException("There is a Table08 record exist for given id");
            } else {
                this.createOrUpdateTable08(table08);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table08 table08) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table08 == null) {
                throw new NullPointerException("table08 cannot be null");
            }
            this.createOrUpdateTable08(table08);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table08> table08List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table08List.size() < 1) {
                throw new NullPointerException("table08 cannot be null");
            }
            for (Table08 obj : table08List) {
                this.deleteTable08ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table08 table08) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable08ById(table08.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 