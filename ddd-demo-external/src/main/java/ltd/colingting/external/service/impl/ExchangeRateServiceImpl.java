package ltd.colingting.external.service.impl;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.external.ExchangeRateService;
import ltd.colingting.external.client.YahooForexService;
import ltd.colingting.types.types.Currency;
import ltd.colingting.types.types.ExchangeRate;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年08月17日 17:31
 */
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final YahooForexService yahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal forex = yahooForexService.getExchangeRate(source.getValue(), target.getValue());
        return new ExchangeRate(forex, source, target);
    }
}
