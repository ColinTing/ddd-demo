package ltd.colingting.web.controller;

import java.math.BigDecimal;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ltd.colingting.application.service.TransferService;
import ltd.colingting.infrastructure.datahelper.vo.Result;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁浩
 * @date 2022年08月17日 13:41
 */
@RestController("transfer/")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    public Result<Boolean> transfer(String targetAccountNumber, BigDecimal amount, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }

}
