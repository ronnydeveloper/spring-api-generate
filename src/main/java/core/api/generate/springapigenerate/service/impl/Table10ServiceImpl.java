package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table10;
import core.api.generate.springapigenerate.repository.Table10Repo;
import core.api.generate.springapigenerate.service.Table10Service;
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

@Service("table10Service")
public class Table10ServiceImpl implements Table10Service {

    static final Logger logger = Logger.getLogger(Table10ServiceImpl.class);

    @Autowired
    private Table10Repo table10Repository;

    @Override
    public Table10 createOrUpdateTable10(Table10 table10) {
         Optional<Table10> table10Optional = table10Repository.findById(table10.getId());
         if(table10Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table10 newTable10 = modelMapper.map(table10, Table10.class);
             newTable10 = table10Repository.save(newTable10);
             return newTable10;
         } else {
             table10 = table10Repository.save(table10);
             return table10;
         }
    }

    @Override
    public void deleteTable10ById(Long id) throws EntityNotFoundException {
         Optional<Table10> table10Optional = table10Repository.findById(id);
         if(table10Optional.isPresent())
         {
            table10Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table10 record exist for given id");
         }
    }

    @Override
    public Table10 getTable10ById(Long id) throws EntityNotFoundException {
         Optional<Table10> table10Optional = table10Repository.findById(id);
         if(table10Optional.isPresent())
         {
            return table10Optional.get();
         } else {
            throw new EntityNotFoundException("No Table10 record exist for given id");
         }
    }

    @Override
    public List<Table10> findAll() {
        List<Table10> list = StreamSupport
                .stream(table10Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table10>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table10> table10List = this.findAll();
             apiResponse.setData(table10List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table10 table10) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table10 == null) {
                throw new NullPointerException("Table10 cannot be null");
            }
            else {
                long max = 0;
                long count = table10Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table10Repository.max();
                }
                table10.setId(max);
            }
            Optional<Table10> table10Optional = table10Repository.findById(table10.getId());
            if(table10Optional.isPresent()) {
                throw new EntityExistsException("There is a Table10 record exist for given id");
            } else {
                this.createOrUpdateTable10(table10);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table10 table10) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table10 == null) {
                throw new NullPointerException("table10 cannot be null");
            }
            this.createOrUpdateTable10(table10);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table10> table10List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table10List.size() < 1) {
                throw new NullPointerException("table10 cannot be null");
            }
            for (Table10 obj : table10List) {
                this.deleteTable10ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table10 table10) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable10ById(table10.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 