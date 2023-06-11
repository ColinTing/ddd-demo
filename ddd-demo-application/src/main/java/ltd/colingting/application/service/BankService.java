package ltd.colingting.application.service;

import ltd.colingting.domain.entity.Money;

/**
 * @author 丁浩
 * @date 2022年08月09日 10:34
 */

public interface BankService {

    void transfer(Money money, Long recipientId);
}
