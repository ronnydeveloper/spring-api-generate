package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table07;
import core.api.generate.springapigenerate.repository.Table07Repo;
import core.api.generate.springapigenerate.service.Table07Service;
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

@Service("table07Service")
public class Table07ServiceImpl implements Table07Service {

    static final Logger logger = Logger.getLogger(Table07ServiceImpl.class);

    @Autowired
    private Table07Repo table07Repository;

    @Override
    public Table07 createOrUpdateTable07(Table07 table07) {
         Optional<Table07> table07Optional = table07Repository.findById(table07.getId());
         if(table07Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table07 newTable07 = modelMapper.map(table07, Table07.class);
             newTable07 = table07Repository.save(newTable07);
             return newTable07;
         } else {
             table07 = table07Repository.save(table07);
             return table07;
         }
    }

    @Override
    public void deleteTable07ById(Long id) throws EntityNotFoundException {
         Optional<Table07> table07Optional = table07Repository.findById(id);
         if(table07Optional.isPresent())
         {
            table07Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table07 record exist for given id");
         }
    }

    @Override
    public Table07 getTable07ById(Long id) throws EntityNotFoundException {
         Optional<Table07> table07Optional = table07Repository.findById(id);
         if(table07Optional.isPresent())
         {
            return table07Optional.get();
         } else {
            throw new EntityNotFoundException("No Table07 record exist for given id");
         }
    }

    @Override
    public List<Table07> findAll() {
        List<Table07> list = StreamSupport
                .stream(table07Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table07>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table07> table07List = this.findAll();
             apiResponse.setData(table07List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table07 table07) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table07 == null) {
                throw new NullPointerException("Table07 cannot be null");
            }
            else {
                long max = 0;
                long count = table07Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table07Repository.max();
                }
                table07.setId(max);
            }
            Optional<Table07> table07Optional = table07Repository.findById(table07.getId());
            if(table07Optional.isPresent()) {
                throw new EntityExistsException("There is a Table07 record exist for given id");
            } else {
                this.createOrUpdateTable07(table07);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table07 table07) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table07 == null) {
                throw new NullPointerException("table07 cannot be null");
            }
            this.createOrUpdateTable07(table07);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table07> table07List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table07List.size() < 1) {
                throw new NullPointerException("table07 cannot be null");
            }
            for (Table07 obj : table07List) {
                this.deleteTable07ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table07 table07) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable07ById(table07.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 