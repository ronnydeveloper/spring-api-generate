package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.Account;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface AccountService {

    Account createOrUpdateAccount(Account account);

    void deleteAccountById(Long id) throws EntityNotFoundException;

    Account getAccountById(Long id) throws EntityNotFoundException;

    List<Account> findAll();

    ApiResponse<List<Account>> doView();

    ApiResponse doAdd(Account account);

    ApiResponse doEdit(Account account);

    ApiResponse doDelete(List<Account> accountList);

    ApiResponse doPreview(Account account);

} 