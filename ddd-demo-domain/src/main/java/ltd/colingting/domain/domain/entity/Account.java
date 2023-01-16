package ltd.colingting.domain.domain.entity;

import lombok.Data;
import ltd.colingting.domain.exception.DailyLimitExceededException;
import ltd.colingting.domain.exception.InsufficientFundsException;
import ltd.colingting.types.exception.InvalidCurrencyException;
import ltd.colingting.types.types.AccountId;
import ltd.colingting.types.types.AccountNumber;
import ltd.colingting.types.types.Currency;
import ltd.colingting.types.types.Money;
import ltd.colingting.types.types.UserId;


/**
 * @author 丁浩
 * @date 2022年08月17日 13:55
 */
@Data
public class Account  {
    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    // 转入
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

    // 转出
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }

}
