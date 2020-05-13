package core.api.generate.springapigenerate.service;

import id.co.ptap.circleaf.core.dto.ApiResponse;
import core.api.generate.springapigenerate.model.CurrencyRate;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CurrencyRateService {

    CurrencyRate createOrUpdateCurrencyRate(CurrencyRate currencyRate);

    void deleteCurrencyRateById(Long id) throws EntityNotFoundException;

    CurrencyRate getCurrencyRateById(Long id) throws EntityNotFoundException;

    List<CurrencyRate> findAll();

    ApiResponse<List<CurrencyRate>> doView();

    ApiResponse doAdd(CurrencyRate currencyRate);

    ApiResponse doEdit(CurrencyRate currencyRate);

    ApiResponse doDelete(List<CurrencyRate> currencyRateList);

    ApiResponse doPreview(CurrencyRate currencyRate);

} 