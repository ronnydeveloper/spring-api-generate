package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table01;
import core.api.generate.springapigenerate.repository.Table01Repo;
import core.api.generate.springapigenerate.service.Table01Service;
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

@Service("table01Service")
public class Table01ServiceImpl implements Table01Service {

    static final Logger logger = Logger.getLogger(Table01ServiceImpl.class);

    @Autowired
    private Table01Repo table01Repository;

    @Override
    public Table01 createOrUpdateTable01(Table01 table01) {
         Optional<Table01> table01Optional = table01Repository.findById(table01.getId());
         if(table01Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table01 newTable01 = modelMapper.map(table01, Table01.class);
             newTable01 = table01Repository.save(newTable01);
             return newTable01;
         } else {
             table01 = table01Repository.save(table01);
             return table01;
         }
    }

    @Override
    public void deleteTable01ById(Long id) throws EntityNotFoundException {
         Optional<Table01> table01Optional = table01Repository.findById(id);
         if(table01Optional.isPresent())
         {
            table01Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table01 record exist for given id");
         }
    }

    @Override
    public Table01 getTable01ById(Long id) throws EntityNotFoundException {
         Optional<Table01> table01Optional = table01Repository.findById(id);
         if(table01Optional.isPresent())
         {
            return table01Optional.get();
         } else {
            throw new EntityNotFoundException("No Table01 record exist for given id");
         }
    }

    @Override
    public List<Table01> findAll() {
        List<Table01> list = StreamSupport
                .stream(table01Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table01>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table01> table01List = this.findAll();
             apiResponse.setData(table01List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table01 table01) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table01 == null) {
                throw new NullPointerException("Table01 cannot be null");
            }
            else {
                long max = 0;
                long count = table01Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table01Repository.max();
                }
                table01.setId(max);
            }
            Optional<Table01> table01Optional = table01Repository.findById(table01.getId());
            if(table01Optional.isPresent()) {
                throw new EntityExistsException("There is a Table01 record exist for given id");
            } else {
                this.createOrUpdateTable01(table01);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table01 table01) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table01 == null) {
                throw new NullPointerException("table01 cannot be null");
            }
            this.createOrUpdateTable01(table01);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table01> table01List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table01List.size() < 1) {
                throw new NullPointerException("table01 cannot be null");
            }
            for (Table01 obj : table01List) {
                this.deleteTable01ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table01 table01) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable01ById(table01.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 