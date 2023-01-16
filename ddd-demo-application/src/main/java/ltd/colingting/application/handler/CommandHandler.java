package ltd.colingting.application.handler;

import ltd.colingting.application.cqe.CheckoutCommand;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月15日 17:01
 */

public interface CommandHandler<T, ID extends Identifier> {

    OrderDTO handle(CheckoutCommand cmd);

}
