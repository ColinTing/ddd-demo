package ltd.colingting.domain.entity;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Value;


/**
 * @author 丁浩
 * @date 2022年08月09日 10:00
 */
@Value
public class Money {
    BigDecimal amount;
    Currency currency;
    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
