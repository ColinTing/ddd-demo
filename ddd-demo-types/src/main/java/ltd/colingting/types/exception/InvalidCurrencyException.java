package ltd.colingting.types.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年08月22日 16:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException() {
        super("无效货币异常");
    }
}
