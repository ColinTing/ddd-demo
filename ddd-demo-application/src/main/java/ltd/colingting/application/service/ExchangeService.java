package ltd.colingting.application.service;

import java.util.Currency;
import ltd.colingting.domain.entity.ExchangeRate;

/**
 * @author 丁浩
 * @date 2022年08月16日 17:26
 */

public interface ExchangeService {


    ExchangeRate getRate(Currency currency, Currency targetCurrency);
}
