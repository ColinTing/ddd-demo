package ltd.colingting.external.client.fallback;

import java.math.BigDecimal;
import ltd.colingting.external.client.YahooForexService;

/**
 * @author 丁浩
 * @date 2022年09月09日 15:29
 */

public class YahooForexFallback implements YahooForexService {

    @Override
    public BigDecimal getExchangeRate(String value, String value1) {
        return null;
    }
}
