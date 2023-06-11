package ltd.colingting.application.service;


import java.util.Currency;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.entity.ExchangeRate;
import ltd.colingting.domain.entity.Money;
import ltd.colingting.domain.entity.SalesRep;
import ltd.colingting.domain.entity.User;
import ltd.colingting.domain.repository.SalesRepRepository;
import ltd.colingting.domain.repository.UserRepository;
import ltd.colingting.domain.vo.Address;
import ltd.colingting.domain.vo.Name;
import ltd.colingting.domain.vo.PhoneNumber;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年07月23日 17:20
 */
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final SalesRepRepository salesRepRepo;

    private final UserRepository userRepo;

    private final BankService bankService;

    private final ExchangeService exchangeService;

    @Override
    public User register(@NotNull Name name, @NotNull PhoneNumber phone, @NotNull Address address) {
        // 找到区域内的SalesRep
        SalesRep rep = salesRepRepo.findRep(phone.getAreaCode());

        // 最后创建用户，落盘，然后返回
        User user = User.builder().name(name).phone(phone).address(address).build();

        if (rep != null) {
            user.setRepId(rep.getRepId());
        }

        return userRepo.saveUser(user);
    }

    @Override
    public void pay(Money money, Currency targetCurrency, Long recipientId) {
        ExchangeRate rate = exchangeService.getRate(money.getCurrency(), targetCurrency);
        Money targetMoney = rate.exchange(money);
        bankService.transfer(targetMoney, recipientId);
    }


}
