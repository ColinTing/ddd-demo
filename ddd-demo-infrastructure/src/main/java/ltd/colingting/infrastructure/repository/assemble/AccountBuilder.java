package ltd.colingting.infrastructure.repository.assemble;

import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.infrastructure.persistence.po.AccountPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年08月17日 15:04
 */
@Mapper(componentModel = "spring")
public interface AccountBuilder {



    @Mappings({
        @Mapping(target = "id.value", source = "id"),
        @Mapping(target = "accountNumber.value", source = "accountNumber"),
        @Mapping(target = "userId.id", source = "userId"),
        @Mapping(target = "available.amount", source = "available"),
        @Mapping(target = "available.currency.value", source = "currency"),
        @Mapping(target = "dailyLimit.amount", source = "dailyLimit")
    })
    Account toAccount(AccountPO accountPO);

    @Mappings({
        @Mapping(target = "id", source = "id.value"),
        @Mapping(target = "accountNumber", source = "accountNumber.value"),
        @Mapping(target = "userId", source = "userId.id"),
        @Mapping(target = "available", source = "available.amount"),
        @Mapping(target = "currency", source = "available.currency.value"),
        @Mapping(target = "dailyLimit", source = "dailyLimit.amount")
    })
    AccountPO fromAccount(Account account);
}
