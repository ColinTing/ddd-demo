package ltd.colingting.domain.repository;

import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.types.types.AccountId;
import ltd.colingting.types.types.AccountNumber;
import ltd.colingting.types.types.UserId;

/**
 * @author 丁浩
 * @date 2022年08月17日 14:34
 */

public interface AccountRepository {

    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    Account find(UserId userId);
    Account save(Account account);

}
