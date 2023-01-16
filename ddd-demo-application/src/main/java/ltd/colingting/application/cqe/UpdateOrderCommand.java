package ltd.colingting.application.cqe;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月15日 17:14
 */
@Data
public class UpdateOrderCommand {

    @NotNull(message = "用户未登陆")
    private Long userId;

    @NotNull(message = "必须要有OrderID")
    private Long orderId;

    @NotNull
    @Positive(message = "需要是合法的itemId")
    private Long itemId;

    @NotNull
    @Min(value = 1, message = "最少1件")
    @Max(value = 1000, message = "最多不能超过1000件")
    private Integer quantity;

}
