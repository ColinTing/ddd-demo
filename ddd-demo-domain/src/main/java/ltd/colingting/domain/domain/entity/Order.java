package ltd.colingting.domain.domain.entity;

import java.util.List;
import java.util.UUID;
import lombok.Data;
import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.types.ItemId;
import ltd.colingting.types.types.Money;
import ltd.colingting.types.types.OrderId;
import ltd.colingting.types.types.OrderState;
import ltd.colingting.types.types.Quantity;
import ltd.colingting.types.types.UserId;

/**
 * @author 丁浩
 * @date 2022年09月01日 13:36
 */
@Data
public class Order  implements Aggregate<OrderId> {


    private OrderId id;

    private UserId userId;

    private Long itemId;

    private Address address;

    private List<LineItem> lineItems;

    private OrderState status;

    private Long buyerId;

    private Long sellerId;

    private String itemTitle;

    private Long itemUnitPrice;

    private Integer count;

    @Override
    public OrderId getId() {
        return  new OrderId(Long.valueOf(UUID.randomUUID().toString()));
    }

    public void addLineItem(ItemId itemId, Quantity quantity, Money money) {

        LineItem lineItem = LineItem.builder().itemId(itemId).quantity(quantity)
            .price(money.getAmount()).build();
        lineItems.add(lineItem);
    }

    public Long getTotalCost() {
        return itemUnitPrice * count;
    }

    public void pay() {


    }
}
