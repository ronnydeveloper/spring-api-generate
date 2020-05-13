package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.JournalView;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface JournalViewService {

    JournalView createOrUpdateJournalView(JournalView journalView);

    void deleteJournalViewById(Long id) throws EntityNotFoundException;

    JournalView getJournalViewById(Long id) throws EntityNotFoundException;

    List<JournalView> findAll();

    ApiResponse<List<JournalView>> doView();

    ApiResponse doAdd(JournalView journalView);

    ApiResponse doEdit(JournalView journalView);

    ApiResponse doDelete(List<JournalView> journalViewList);

    ApiResponse doPreview(JournalView journalView);

} 