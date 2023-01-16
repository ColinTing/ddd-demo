package ltd.colingting.external.client;

import ltd.colingting.external.client.fallback.ExternalInventoryFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:30
 */
@FeignClient(name = "external-inventory", fallback = ExternalInventoryFallback.class)
public interface ExternalInventoryService {

    @RequestMapping(value = "/withhold", method = RequestMethod.POST)
    boolean withhold(@RequestParam Long itemId, @RequestParam Integer quantity);
}
