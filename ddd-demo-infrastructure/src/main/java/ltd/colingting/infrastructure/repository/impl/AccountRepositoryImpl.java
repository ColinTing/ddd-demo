package ltd.colingting.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.domain.repository.AccountRepository;
import ltd.colingting.infrastructure.persistence.mapper.AccountMapper;
import ltd.colingting.infrastructure.persistence.po.AccountPO;
import ltd.colingting.infrastructure.repository.assemble.AccountBuilder;
import ltd.colingting.types.types.AccountId;
import ltd.colingting.types.types.AccountNumber;
import ltd.colingting.types.types.UserId;
import org.springframework.stereotype.Repository;

/**
 * @author 丁浩
 * @date 2022年08月17日 14:36
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {


    private final AccountMapper accountDAO;


    private final AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId id) {
        AccountPO accountPO = accountDAO.selectById(id.getValue());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountPO accountPO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account find(UserId userId) {
        AccountPO accountPO = accountDAO.selectByUserId(userId.getId());
        return accountBuilder.toAccount(accountPO);
    }

    @Override
    public Account save(Account account) {
        AccountPO accountPO = accountBuilder.fromAccount(account);
        if (accountPO.getId() == null) {
            accountDAO.insert(accountPO);
        } else {
            accountDAO.updateById(accountPO);
        }
        return accountBuilder.toAccount(accountPO);
    }

}
