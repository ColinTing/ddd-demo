package ltd.colingting.web.controller;

import lombok.RequiredArgsConstructor;
import ltd.colingting.application.cqe.CheckoutCommand;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.application.service.CheckoutService;
import ltd.colingting.infrastructure.datahelper.exception.ResultHandler;
import ltd.colingting.infrastructure.datahelper.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁浩
 * @date 2022年09月15日 10:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @ResultHandler
    @PostMapping("checkout")
    public Result<OrderDTO> checkout(Long itemId, Integer quantity) {
        CheckoutCommand cmd = new CheckoutCommand();
        OrderDTO orderDTO = checkoutService.checkout(cmd);
        return Result.success(orderDTO);
    }
}
