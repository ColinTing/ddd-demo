package ltd.colingting.external.client;

import ltd.colingting.external.client.fallback.ExternalItemFallback;
import ltd.colingting.external.persistence.ItemDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:18
 */
@FeignClient(name = "external-item", fallback = ExternalItemFallback.class)
public interface ExternalItemService {

    @RequestMapping(value = "/getItem", method = RequestMethod.POST)
    ItemDO getItem(@RequestParam Long itemId);
}
