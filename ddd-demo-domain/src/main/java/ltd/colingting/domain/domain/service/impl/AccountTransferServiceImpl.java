package ltd.colingting.domain.domain.service.impl;

import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.domain.domain.service.AccountTransferService;
import ltd.colingting.types.types.ExchangeRate;
import ltd.colingting.types.types.Money;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年08月22日 16:46
 */
@Service
public class AccountTransferServiceImpl implements AccountTransferService {



    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney,
        ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
