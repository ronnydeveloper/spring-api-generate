package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table09;
import core.api.generate.springapigenerate.repository.Table09Repo;
import core.api.generate.springapigenerate.service.Table09Service;
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

@Service("table09Service")
public class Table09ServiceImpl implements Table09Service {

    static final Logger logger = Logger.getLogger(Table09ServiceImpl.class);

    @Autowired
    private Table09Repo table09Repository;

    @Override
    public Table09 createOrUpdateTable09(Table09 table09) {
         Optional<Table09> table09Optional = table09Repository.findById(table09.getId());
         if(table09Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table09 newTable09 = modelMapper.map(table09, Table09.class);
             newTable09 = table09Repository.save(newTable09);
             return newTable09;
         } else {
             table09 = table09Repository.save(table09);
             return table09;
         }
    }

    @Override
    public void deleteTable09ById(Long id) throws EntityNotFoundException {
         Optional<Table09> table09Optional = table09Repository.findById(id);
         if(table09Optional.isPresent())
         {
            table09Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table09 record exist for given id");
         }
    }

    @Override
    public Table09 getTable09ById(Long id) throws EntityNotFoundException {
         Optional<Table09> table09Optional = table09Repository.findById(id);
         if(table09Optional.isPresent())
         {
            return table09Optional.get();
         } else {
            throw new EntityNotFoundException("No Table09 record exist for given id");
         }
    }

    @Override
    public List<Table09> findAll() {
        List<Table09> list = StreamSupport
                .stream(table09Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table09>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table09> table09List = this.findAll();
             apiResponse.setData(table09List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table09 table09) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table09 == null) {
                throw new NullPointerException("Table09 cannot be null");
            }
            else {
                long max = 0;
                long count = table09Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table09Repository.max();
                }
                table09.setId(max);
            }
            Optional<Table09> table09Optional = table09Repository.findById(table09.getId());
            if(table09Optional.isPresent()) {
                throw new EntityExistsException("There is a Table09 record exist for given id");
            } else {
                this.createOrUpdateTable09(table09);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table09 table09) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table09 == null) {
                throw new NullPointerException("table09 cannot be null");
            }
            this.createOrUpdateTable09(table09);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table09> table09List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table09List.size() < 1) {
                throw new NullPointerException("table09 cannot be null");
            }
            for (Table09 obj : table09List) {
                this.deleteTable09ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table09 table09) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable09ById(table09.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 