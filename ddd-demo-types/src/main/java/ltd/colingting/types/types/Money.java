package ltd.colingting.types.types;

import java.math.BigDecimal;

import lombok.Value;


/**
 * @author 丁浩
 * @date 2022年08月09日 10:00
 */
@Value
public class Money implements Comparable<Money> {
    BigDecimal amount;
    Currency currency;
    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public int compareTo(Money otherMoney) {
        return getAmount().compareTo(otherMoney.getAmount());
    }

    public Money add(Money money) {
        return new Money(getAmount().add(money.getAmount()),getCurrency());
    }

    public Money subtract(Money money) {
        return new Money(getAmount().subtract(money.getAmount()), getCurrency());
    }
}
