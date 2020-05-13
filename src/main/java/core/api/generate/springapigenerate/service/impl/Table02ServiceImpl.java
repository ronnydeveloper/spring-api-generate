package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table02;
import core.api.generate.springapigenerate.repository.Table02Repo;
import core.api.generate.springapigenerate.service.Table02Service;
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

@Service("table02Service")
public class Table02ServiceImpl implements Table02Service {

    static final Logger logger = Logger.getLogger(Table02ServiceImpl.class);

    @Autowired
    private Table02Repo table02Repository;

    @Override
    public Table02 createOrUpdateTable02(Table02 table02) {
         Optional<Table02> table02Optional = table02Repository.findById(table02.getId());
         if(table02Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table02 newTable02 = modelMapper.map(table02, Table02.class);
             newTable02 = table02Repository.save(newTable02);
             return newTable02;
         } else {
             table02 = table02Repository.save(table02);
             return table02;
         }
    }

    @Override
    public void deleteTable02ById(Long id) throws EntityNotFoundException {
         Optional<Table02> table02Optional = table02Repository.findById(id);
         if(table02Optional.isPresent())
         {
            table02Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table02 record exist for given id");
         }
    }

    @Override
    public Table02 getTable02ById(Long id) throws EntityNotFoundException {
         Optional<Table02> table02Optional = table02Repository.findById(id);
         if(table02Optional.isPresent())
         {
            return table02Optional.get();
         } else {
            throw new EntityNotFoundException("No Table02 record exist for given id");
         }
    }

    @Override
    public List<Table02> findAll() {
        List<Table02> list = StreamSupport
                .stream(table02Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table02>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table02> table02List = this.findAll();
             apiResponse.setData(table02List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table02 table02) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table02 == null) {
                throw new NullPointerException("Table02 cannot be null");
            }
            else {
                long max = 0;
                long count = table02Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table02Repository.max();
                }
                table02.setId(max);
            }
            Optional<Table02> table02Optional = table02Repository.findById(table02.getId());
            if(table02Optional.isPresent()) {
                throw new EntityExistsException("There is a Table02 record exist for given id");
            } else {
                this.createOrUpdateTable02(table02);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table02 table02) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table02 == null) {
                throw new NullPointerException("table02 cannot be null");
            }
            this.createOrUpdateTable02(table02);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table02> table02List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table02List.size() < 1) {
                throw new NullPointerException("table02 cannot be null");
            }
            for (Table02 obj : table02List) {
                this.deleteTable02ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table02 table02) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable02ById(table02.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 