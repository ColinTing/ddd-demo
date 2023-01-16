package ltd.colingting.application.service.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.application.assemble.OrderDtoAssembler;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.application.service.OrderService;
import ltd.colingting.domain.domain.entity.Item;
import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.domain.repository.ItemRepository;
import ltd.colingting.domain.repository.OrderRepository;
import ltd.colingting.types.types.OrderId;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:16
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDtoAssembler assembler;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Override
    public OrderDTO getOrderDetail(OrderId orderId) {
        Order order = orderRepository.find(orderId);
        Item item = itemRepository.find(order.getItemId());
        return assembler.toDTO(order, item); // 原来的很多复杂转化逻辑都收敛到一行代码了
    }

}
