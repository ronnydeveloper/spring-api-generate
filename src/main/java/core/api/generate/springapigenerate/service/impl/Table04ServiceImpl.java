package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Table04;
import core.api.generate.springapigenerate.repository.Table04Repo;
import core.api.generate.springapigenerate.service.Table04Service;
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

@Service("table04Service")
public class Table04ServiceImpl implements Table04Service {

    static final Logger logger = Logger.getLogger(Table04ServiceImpl.class);

    @Autowired
    private Table04Repo table04Repository;

    @Override
    public Table04 createOrUpdateTable04(Table04 table04) {
         Optional<Table04> table04Optional = table04Repository.findById(table04.getId());
         if(table04Optional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Table04 newTable04 = modelMapper.map(table04, Table04.class);
             newTable04 = table04Repository.save(newTable04);
             return newTable04;
         } else {
             table04 = table04Repository.save(table04);
             return table04;
         }
    }

    @Override
    public void deleteTable04ById(Long id) throws EntityNotFoundException {
         Optional<Table04> table04Optional = table04Repository.findById(id);
         if(table04Optional.isPresent())
         {
            table04Repository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Table04 record exist for given id");
         }
    }

    @Override
    public Table04 getTable04ById(Long id) throws EntityNotFoundException {
         Optional<Table04> table04Optional = table04Repository.findById(id);
         if(table04Optional.isPresent())
         {
            return table04Optional.get();
         } else {
            throw new EntityNotFoundException("No Table04 record exist for given id");
         }
    }

    @Override
    public List<Table04> findAll() {
        List<Table04> list = StreamSupport
                .stream(table04Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Table04>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Table04> table04List = this.findAll();
             apiResponse.setData(table04List);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Table04 table04) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (table04 == null) {
                throw new NullPointerException("Table04 cannot be null");
            }
            else {
                long max = 0;
                long count = table04Repository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = table04Repository.max();
                }
                table04.setId(max);
            }
            Optional<Table04> table04Optional = table04Repository.findById(table04.getId());
            if(table04Optional.isPresent()) {
                throw new EntityExistsException("There is a Table04 record exist for given id");
            } else {
                this.createOrUpdateTable04(table04);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Table04 table04) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table04 == null) {
                throw new NullPointerException("table04 cannot be null");
            }
            this.createOrUpdateTable04(table04);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Table04> table04List) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (table04List.size() < 1) {
                throw new NullPointerException("table04 cannot be null");
            }
            for (Table04 obj : table04List) {
                this.deleteTable04ById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Table04 table04) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getTable04ById(table04.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 