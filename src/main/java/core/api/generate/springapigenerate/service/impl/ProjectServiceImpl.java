package core.api.generate.springapigenerate.service.impl;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import id.co.ptap.circleaf.core.enums.ResponseCode;
import core.api.generate.springapigenerate.model.Project;
import core.api.generate.springapigenerate.repository.ProjectRepo;
import core.api.generate.springapigenerate.service.ProjectService;
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

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepo projectRepository;

    @Override
    public Project createOrUpdateProject(Project project) {
         Optional<Project> projectOptional = projectRepository.findById(project.getId());
         if(projectOptional.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Project newProject = modelMapper.map(project, Project.class);
             newProject = projectRepository.save(newProject);
             return newProject;
         } else {
             project = projectRepository.save(project);
             return project;
         }
    }

    @Override
    public void deleteProjectById(Long id) throws EntityNotFoundException {
         Optional<Project> projectOptional = projectRepository.findById(id);
         if(projectOptional.isPresent())
         {
            projectRepository.deleteById(id);
         } else {
            throw new EntityNotFoundException("No Project record exist for given id");
         }
    }

    @Override
    public Project getProjectById(Long id) throws EntityNotFoundException {
         Optional<Project> projectOptional = projectRepository.findById(id);
         if(projectOptional.isPresent())
         {
            return projectOptional.get();
         } else {
            throw new EntityNotFoundException("No Project record exist for given id");
         }
    }

    @Override
    public List<Project> findAll() {
        List<Project> list = StreamSupport
                .stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public ApiResponse<List<Project>> doView() {
         ApiResponse apiResponse = new ApiResponse();
         try {
             List<Project> projectList = this.findAll();
             apiResponse.setData(projectList);
         } catch (Exception var3) {
             logger.error(var3);
             apiResponse.setResponseCodeEnum(ResponseCode._999);
             apiResponse.setResponseMessage(var3.getMessage());
         }
         return apiResponse;
    }

    @Override
    public ApiResponse doAdd(Project project) {
         ApiResponse apiResponse = new ApiResponse();
         try {
            if (project == null) {
                throw new NullPointerException("Project cannot be null");
            }
            else {
                long max = 0;
                long count = projectRepository.count();
                if(count < 1) {
                    max = 1;
                } else {
                    max = projectRepository.max();
                }
                project.setId(max);
            }
            Optional<Project> projectOptional = projectRepository.findById(project.getId());
            if(projectOptional.isPresent()) {
                throw new EntityExistsException("There is a Project record exist for given id");
            } else {
                this.createOrUpdateProject(project);
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doEdit(Project project) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (project == null) {
                throw new NullPointerException("project cannot be null");
            }
            this.createOrUpdateProject(project);
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doDelete(List<Project> projectList) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if (projectList.size() < 1) {
                throw new NullPointerException("project cannot be null");
            }
            for (Project obj : projectList) {
                this.deleteProjectById(obj.getId());
            }
        } catch (Exception var5) {
            logger.error(var5);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var5.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse doPreview(Project project) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(this.getProjectById(project.getId()));
        } catch (Exception var3) {
            logger.error(var3);
            apiResponse.setResponseCodeEnum(ResponseCode._999);
            apiResponse.setResponseMessage(var3.getMessage());
        }
        return apiResponse;
    }

} 