package ltd.colingting.domain.entity;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Value;

/**
 * @author 丁浩
 * @date 2022年08月16日 09:54
 */
@Value
public class ExchangeRate {
    BigDecimal rate;
    Currency from;
    Currency to;

    public ExchangeRate(BigDecimal rate, Currency from, Currency to) {
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public Money exchange(Money fromMoney) {
        notNull(fromMoney);
        isTrue(this.from.equals(fromMoney.getCurrency()));
        BigDecimal targetAmount = fromMoney.getAmount().multiply(rate);
        return new Money(targetAmount, to);
    }
}
