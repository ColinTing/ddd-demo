package ltd.colingting.application.service;

import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.types.types.OrderId;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:15
 */

public interface OrderService {

    OrderDTO getOrderDetail(OrderId orderId);

}
