package ltd.colingting.application.service;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.entity.Money;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年08月09日 10:37
 */
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{



    @Override
    public void transfer(Money money, Long recipientId) {

    }
}
