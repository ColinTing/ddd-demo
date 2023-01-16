package ltd.colingting.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年08月22日 16:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException() {
        super("资金不足异常");
    }
}
