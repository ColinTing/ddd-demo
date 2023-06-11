package ltd.colingting.application.service;

import java.util.Currency;
import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.entity.ExchangeRate;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年08月16日 17:27
 */
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public ExchangeRate getRate(Currency currency, Currency targetCurrency) {
        return null;
    }
}
