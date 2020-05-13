package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.StaticData;
import core.api.generate.springapigenerate.repository.StaticDataRepo;
import core.api.generate.springapigenerate.service.StaticDataService;
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

@Service("staticDataService")
public class StaticDataServiceImpl implements StaticDataService {

    static final Logger logger = Logger.getLogger(StaticDataServiceImpl.class);

    @Autowired
    private StaticDataRepo staticDataRepository;

    @Override
    public StaticData createOrUpdateStaticData(StaticData staticData) {
         Optional<StaticData> staticDataOptional = staticDataRepository.findById(staticData.getId());
         if(staticDataOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             StaticData newStaticData = modelMapper.map(staticData, StaticData.class);
             newStaticData = staticDataRepository.save(newStaticData);
             return newStaticData;
         } else {
             staticData = staticDataRepository.save(staticData);
             return staticData;
         }
    }

    @Override
    public void deleteStaticDataById(Long id) throws EntityNotFoundException {
         Optional<StaticData> staticDataOptional = staticDataRepository.findById(id);
         if(staticDataOptional.isPresent())
         {
            staticDataRepository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No StaticData record exist for given id");
         }
    }

    @Override
    public StaticData getStaticDataById(Long id) throws EntityNotFoundException {
         Optional<StaticData> staticDataOptional = staticDataRepository.findById(id);
         if(staticDataOptional.isPresent())
         {
            return staticDataOptional.get();
         } else {
            throw new EntityNotFoundException("No StaticData record exist for given id");
         }
    }

    @Override
    public List<StaticData> findAll() {
        List<StaticData> list = StreamSupport
                .stream(staticDataRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<StaticData>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<StaticData> staticDataList = this.findAll();
             apiResponse.setData(staticDataList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(StaticData staticData) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (staticData == null) {
                throw new NullPointerException("StaticData cannot be null");
            }
            else {
                long max = 0;
                long count = staticDataRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = staticDataRepository.max();
                }
                staticData.setId(max);
            }
            Optional<StaticData> staticDataOptional = staticDataRepository.findById(staticData.getId());
            if(staticDataOptional.isPresent()) {
                throw new EntityExistsException("There is a StaticData record exist for given id");
            } else {
                this.createOrUpdateStaticData(staticData);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(StaticData staticData) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (staticData == null) {
                throw new NullPointerException("staticData cannot be null");
            }
            this.createOrUpdateStaticData(staticData);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<StaticData> staticDataList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (staticDataList.size() < 1) {
                throw new NullPointerException("staticData cannot be null");
            }
            for (StaticData obj : staticDataList) {
                this.deleteStaticDataById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(StaticData staticData) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getStaticDataById(staticData.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 