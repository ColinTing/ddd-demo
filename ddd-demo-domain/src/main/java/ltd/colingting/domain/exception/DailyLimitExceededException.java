package ltd.colingting.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年08月22日 16:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DailyLimitExceededException extends RuntimeException {

    public DailyLimitExceededException() {
        super("每日极限超越异常");
    }
}
