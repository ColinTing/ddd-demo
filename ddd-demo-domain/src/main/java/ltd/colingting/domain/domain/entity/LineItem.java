package ltd.colingting.domain.domain.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import ltd.colingting.types.types.ItemId;
import ltd.colingting.types.types.LineItemId;
import ltd.colingting.types.types.OrderId;
import ltd.colingting.types.types.Quantity;

/**
 *
 * 子订单实体
 * @author 丁浩
 * @date 2022年09月03日 20:04
 */
@Data
@Builder
public class LineItem {

    private LineItemId id;
    // 主订单ID
    private OrderId orderId;
    // 商品ID
    private ItemId itemId;
    // 价格
    private BigDecimal price;

    private Quantity quantity;

}
