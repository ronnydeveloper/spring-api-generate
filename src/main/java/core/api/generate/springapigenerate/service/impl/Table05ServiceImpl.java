package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table05;
import core.api.generate.springapigenerate.repository.Table05Repo;
import core.api.generate.springapigenerate.service.Table05Service;
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

@Service("table05Service")
public class Table05ServiceImpl implements Table05Service {

    static final Logger logger = Logger.getLogger(Table05ServiceImpl.class);

    @Autowired
    private Table05Repo table05Repository;

    @Override
    public Table05 createOrUpdateTable05(Table05 table05) {
         Optional<Table05> table05Optional = table05Repository.findById(table05.getId());
         if(table05Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table05 newTable05 = modelMapper.map(table05, Table05.class);
             newTable05 = table05Repository.save(newTable05);
             return newTable05;
         } else {
             table05 = table05Repository.save(table05);
             return table05;
         }
    }

    @Override
    public void deleteTable05ById(Long id) throws EntityNotFoundException {
         Optional<Table05> table05Optional = table05Repository.findById(id);
         if(table05Optional.isPresent())
         {
            table05Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table05 record exist for given id");
         }
    }

    @Override
    public Table05 getTable05ById(Long id) throws EntityNotFoundException {
         Optional<Table05> table05Optional = table05Repository.findById(id);
         if(table05Optional.isPresent())
         {
            return table05Optional.get();
         } else {
            throw new EntityNotFoundException("No Table05 record exist for given id");
         }
    }

    @Override
    public List<Table05> findAll() {
        List<Table05> list = StreamSupport
                .stream(table05Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table05>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table05> table05List = this.findAll();
             apiResponse.setData(table05List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table05 table05) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table05 == null) {
                throw new NullPointerException("Table05 cannot be null");
            }
            else {
                long max = 0;
                long count = table05Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table05Repository.max();
                }
                table05.setId(max);
            }
            Optional<Table05> table05Optional = table05Repository.findById(table05.getId());
            if(table05Optional.isPresent()) {
                throw new EntityExistsException("There is a Table05 record exist for given id");
            } else {
                this.createOrUpdateTable05(table05);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table05 table05) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table05 == null) {
                throw new NullPointerException("table05 cannot be null");
            }
            this.createOrUpdateTable05(table05);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table05> table05List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table05List.size() < 1) {
                throw new NullPointerException("table05 cannot be null");
            }
            for (Table05 obj : table05List) {
                this.deleteTable05ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table05 table05) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable05ById(table05.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 