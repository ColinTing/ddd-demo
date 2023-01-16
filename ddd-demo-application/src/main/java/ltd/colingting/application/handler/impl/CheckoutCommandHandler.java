package ltd.colingting.application.handler.impl;

import ltd.colingting.application.cqe.CheckoutCommand;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.application.handler.CommandHandler;


/**
 * @author 丁浩
 * @date 2022年09月15日 17:19
 */

public class CheckoutCommandHandler implements CommandHandler<CheckoutCommand, OrderDTO> {

    @Override
    public OrderDTO handle(CheckoutCommand cmd) {
        return null;
    }
}
