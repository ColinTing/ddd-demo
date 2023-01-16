package ltd.colingting.application.service;

import java.util.List;
import javax.validation.Valid;
import ltd.colingting.application.cqe.CheckoutCommand;
import ltd.colingting.application.cqe.OrderQuery;
import ltd.colingting.application.cqe.UpdateOrderCommand;
import ltd.colingting.application.dto.OrderDTO;

/**
 * @author 丁浩
 * @date 2022年09月15日 14:53
 */

public interface CheckoutService {
    // 下单
    OrderDTO checkout(@Valid CheckoutCommand cmd);

    OrderDTO updateOrder(@Valid UpdateOrderCommand cmd);
//    // 支付成功
//    OrderDTO payReceived(@Valid PaymentReceivedEvent event);
//    // 支付取消
//    OrderDTO payCanceled(@Valid PaymentCanceledEvent event);
//    // 发货
//    OrderDTO packageSent(@Valid PackageSentEvent event);
//    // 收货
//    OrderDTO delivered(@Valid DeliveredEvent event);
    // 批量查询
    List<OrderDTO> query(OrderQuery query);
    //单个查询
    OrderDTO getOrder(Long orderId); // 注意单一ID查询可以不用Query
}
