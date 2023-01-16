package ltd.colingting.application.service.impl;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import ltd.colingting.application.service.TransferService;
import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.domain.domain.service.AccountTransferService;
import ltd.colingting.domain.domain.types.AuditMessage;
import ltd.colingting.domain.external.ExchangeRateService;
import ltd.colingting.domain.messaging.AuditMessageProducer;
import ltd.colingting.domain.repository.AccountRepository;
import ltd.colingting.infrastructure.datahelper.vo.Result;
import ltd.colingting.types.types.AccountNumber;
import ltd.colingting.types.types.Currency;
import ltd.colingting.types.types.ExchangeRate;
import ltd.colingting.types.types.Money;
import ltd.colingting.types.types.UserId;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年08月22日 17:20
 */
@Service
@RequiredArgsConstructor
public class TransferServiceImplNew implements TransferService {

    private final AccountRepository accountRepository;
    private final AuditMessageProducer auditMessageProducer;
    private final ExchangeRateService exchangeRateService;
    private final AccountTransferService accountTransferService;

    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount,
        String targetCurrency) {
        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        // 读数据
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return Result.success(true);
    }
}
