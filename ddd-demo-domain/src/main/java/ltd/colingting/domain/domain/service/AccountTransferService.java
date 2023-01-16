package ltd.colingting.domain.domain.service;

import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.types.types.ExchangeRate;
import ltd.colingting.types.types.Money;

/**
 * @author 丁浩
 * @date 2022年08月22日 16:45
 */

public interface AccountTransferService {
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
