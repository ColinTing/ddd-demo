package ltd.colingting.domain.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import ltd.colingting.types.types.Payment;
import ltd.colingting.types.types.Shipping;

/**
 * @author 丁浩
 * @date 2022年09月13日 16:34
 */
@Data
@Setter(AccessLevel.PRIVATE) // 确保不生成public setter
public class OrderEasy {
    private int status; // 0 - 创建，1 - 支付，2 - 发货，3 - 收货
    private Payment payment; // 支付单
    private Shipping shipping; // 物流单

    public void pay(Long userId, Long amount) {
        if (status != 0) {
            throw new IllegalStateException();
        }
        this.status = 1;
        this.payment = new Payment(userId, amount);
    }

    public void ship(String trackingNumber) {
        if (status != 1) {
            throw new IllegalStateException();
        }
        this.status = 2;
        this.shipping = new Shipping(trackingNumber);
    }
}
