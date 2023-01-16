package ltd.colingting.application.service.impl;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import ltd.colingting.application.assemble.OrderDtoAssembler;
import ltd.colingting.application.cqe.CheckoutCommand;
import ltd.colingting.application.cqe.OrderQuery;
import ltd.colingting.application.cqe.UpdateOrderCommand;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.application.service.CheckoutService;
import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.domain.repository.OrderRepository;
import ltd.colingting.external.dto.ItemDTO;
import ltd.colingting.external.facade.InventoryFacade;
import ltd.colingting.external.facade.ItemFacade;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author 丁浩
 * @date 2022年09月15日 15:49
 */
@Validated
@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderDtoAssembler orderDtoAssembler = OrderDtoAssembler.INSTANCE;


    private final ItemFacade itemFacade;

    private final InventoryFacade inventoryFacade;

    private final OrderRepository orderRepository;


//    private final CheckoutCommandHandler checkoutCommandHandler;

    @Override
    public OrderDTO checkout(@Valid CheckoutCommand cmd) {
        ItemDTO item = itemFacade.getItem(cmd.getItemId());
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        }

        boolean withholdSuccess = inventoryFacade.withhold(cmd.getItemId(), cmd.getQuantity());
        if (!withholdSuccess) {
            throw new IllegalArgumentException("Inventory not enough");
        }

        Order order = new Order();
        order.setBuyerId(cmd.getUserId());
        order.setSellerId(item.getSellerId());
        order.setItemId(item.getItemId());
        order.setItemTitle(item.getTitle());
        order.setItemUnitPrice(item.getPriceInCents());
        order.setCount(cmd.getQuantity());

        Order savedOrder = orderRepository.save(order);

        return orderDtoAssembler.orderToDTO(savedOrder);

//        return checkoutCommandHandler.handle(cmd);
    }

    @Override
    public OrderDTO updateOrder(@Valid UpdateOrderCommand cmd) {
        return null;
    }

//    @Override
//    public OrderDTO payReceived(PaymentReceivedEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO payCanceled(PaymentCanceledEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO packageSent(PackageSentEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO delivered(DeliveredEvent event) {
//        return null;
//    }

    @Override
    public List<OrderDTO> query(OrderQuery query) {
        return null;
    }

    @Override
    public OrderDTO getOrder(Long orderId) {
        return null;
    }
}
