package ltd.colingting.application.service;

import java.util.Currency;
import javax.validation.constraints.NotNull;
import ltd.colingting.domain.entity.Money;
import ltd.colingting.domain.entity.User;
import ltd.colingting.domain.vo.Address;
import ltd.colingting.domain.vo.Name;
import ltd.colingting.domain.vo.PhoneNumber;

/**
 * @author 丁浩
 * @date 2022年07月23日 17:19
 */

public interface RegistrationService {

    User register(@NotNull Name name, @NotNull PhoneNumber phone, @NotNull Address address);

    void pay(Money money, Currency targetCurrency, Long recipientId);
}
