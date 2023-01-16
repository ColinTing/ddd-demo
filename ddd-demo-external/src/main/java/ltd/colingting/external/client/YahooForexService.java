package ltd.colingting.external.client;


import java.math.BigDecimal;
import ltd.colingting.external.client.fallback.YahooForexFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 文件远端请求
 *
 * @author 丁浩
 * @date 2022/7/25 10:13
 */
@FeignClient(name = "yahoo-forex", fallback = YahooForexFallback.class)
public interface YahooForexService {


	@RequestMapping(value = "/getExchangeRate", method = RequestMethod.POST)
	BigDecimal getExchangeRate(@RequestParam String value, @RequestParam String value1);
}
