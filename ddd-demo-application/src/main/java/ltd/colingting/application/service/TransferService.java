package ltd.colingting.application.service;

import java.math.BigDecimal;
import ltd.colingting.infrastructure.datahelper.vo.Result;

/**
 * @author 丁浩
 * @date 2022年08月17日 13:42
 */

public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency);
}
