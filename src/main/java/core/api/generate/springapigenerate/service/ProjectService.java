package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Project;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ProjectService {

    Project createOrUpdateProject(Project project);

    void deleteProjectById(Long id) throws EntityNotFoundException;

    Project getProjectById(Long id) throws EntityNotFoundException;

    List<Project> findAll();

    ApiResponse<List<Project>> doView();

    ApiResponse doAdd(Project project);

    ApiResponse doEdit(Project project);

    ApiResponse doDelete(List<Project> projectList);

    ApiResponse doPreview(Project project);

} 