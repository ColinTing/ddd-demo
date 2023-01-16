package ltd.colingting.domain.external;

import ltd.colingting.types.types.Currency;
import ltd.colingting.types.types.ExchangeRate;

/**
 * @author 丁浩
 * @date 2022年08月17日 17:30
 */

public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);
}
