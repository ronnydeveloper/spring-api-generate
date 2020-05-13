package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table06;
import core.api.generate.springapigenerate.repository.Table06Repo;
import core.api.generate.springapigenerate.service.Table06Service;
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

@Service("table06Service")
public class Table06ServiceImpl implements Table06Service {

    static final Logger logger = Logger.getLogger(Table06ServiceImpl.class);

    @Autowired
    private Table06Repo table06Repository;

    @Override
    public Table06 createOrUpdateTable06(Table06 table06) {
         Optional<Table06> table06Optional = table06Repository.findById(table06.getId());
         if(table06Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table06 newTable06 = modelMapper.map(table06, Table06.class);
             newTable06 = table06Repository.save(newTable06);
             return newTable06;
         } else {
             table06 = table06Repository.save(table06);
             return table06;
         }
    }

    @Override
    public void deleteTable06ById(Long id) throws EntityNotFoundException {
         Optional<Table06> table06Optional = table06Repository.findById(id);
         if(table06Optional.isPresent())
         {
            table06Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table06 record exist for given id");
         }
    }

    @Override
    public Table06 getTable06ById(Long id) throws EntityNotFoundException {
         Optional<Table06> table06Optional = table06Repository.findById(id);
         if(table06Optional.isPresent())
         {
            return table06Optional.get();
         } else {
            throw new EntityNotFoundException("No Table06 record exist for given id");
         }
    }

    @Override
    public List<Table06> findAll() {
        List<Table06> list = StreamSupport
                .stream(table06Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table06>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table06> table06List = this.findAll();
             apiResponse.setData(table06List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table06 table06) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table06 == null) {
                throw new NullPointerException("Table06 cannot be null");
            }
            else {
                long max = 0;
                long count = table06Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table06Repository.max();
                }
                table06.setId(max);
            }
            Optional<Table06> table06Optional = table06Repository.findById(table06.getId());
            if(table06Optional.isPresent()) {
                throw new EntityExistsException("There is a Table06 record exist for given id");
            } else {
                this.createOrUpdateTable06(table06);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table06 table06) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table06 == null) {
                throw new NullPointerException("table06 cannot be null");
            }
            this.createOrUpdateTable06(table06);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table06> table06List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table06List.size() < 1) {
                throw new NullPointerException("table06 cannot be null");
            }
            for (Table06 obj : table06List) {
                this.deleteTable06ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table06 table06) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable06ById(table06.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 