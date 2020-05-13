package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.JournalView;
import core.api.generate.springapigenerate.repository.JournalViewRepo;
import core.api.generate.springapigenerate.service.JournalViewService;
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

@Service("journalViewService")
public class JournalViewServiceImpl implements JournalViewService {

    static final Logger logger = Logger.getLogger(JournalViewServiceImpl.class);

    @Autowired
    private JournalViewRepo journalViewRepository;

    @Override
    public JournalView createOrUpdateJournalView(JournalView journalView) {
         Optional<JournalView> journalViewOptional = journalViewRepository.findById(journalView.getId());
         if(journalViewOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             JournalView newJournalView = modelMapper.map(journalView, JournalView.class);
             newJournalView = journalViewRepository.save(newJournalView);
             return newJournalView;
         } else {
             journalView = journalViewRepository.save(journalView);
             return journalView;
         }
    }

    @Override
    public void deleteJournalViewById(Long id) throws EntityNotFoundException {
         Optional<JournalView> journalViewOptional = journalViewRepository.findById(id);
         if(journalViewOptional.isPresent())
         {
            journalViewRepository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No JournalView record exist for given id");
         }
    }

    @Override
    public JournalView getJournalViewById(Long id) throws EntityNotFoundException {
         Optional<JournalView> journalViewOptional = journalViewRepository.findById(id);
         if(journalViewOptional.isPresent())
         {
            return journalViewOptional.get();
         } else {
            throw new EntityNotFoundException("No JournalView record exist for given id");
         }
    }

    @Override
    public List<JournalView> findAll() {
        List<JournalView> list = StreamSupport
                .stream(journalViewRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<JournalView>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<JournalView> journalViewList = this.findAll();
             apiResponse.setData(journalViewList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(JournalView journalView) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (journalView == null) {
                throw new NullPointerException("JournalView cannot be null");
            }
            else {
                long max = 0;
                long count = journalViewRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = journalViewRepository.max();
                }
                journalView.setId(max);
            }
            Optional<JournalView> journalViewOptional = journalViewRepository.findById(journalView.getId());
            if(journalViewOptional.isPresent()) {
                throw new EntityExistsException("There is a JournalView record exist for given id");
            } else {
                this.createOrUpdateJournalView(journalView);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(JournalView journalView) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (journalView == null) {
                throw new NullPointerException("journalView cannot be null");
            }
            this.createOrUpdateJournalView(journalView);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<JournalView> journalViewList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (journalViewList.size() < 1) {
                throw new NullPointerException("journalView cannot be null");
            }
            for (JournalView obj : journalViewList) {
                this.deleteJournalViewById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(JournalView journalView) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getJournalViewById(journalView.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 