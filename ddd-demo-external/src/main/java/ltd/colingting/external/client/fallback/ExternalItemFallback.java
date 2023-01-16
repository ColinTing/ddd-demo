package ltd.colingting.external.client.fallback;

import ltd.colingting.external.client.ExternalItemService;
import ltd.colingting.external.persistence.ItemDO;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:19
 */

public class ExternalItemFallback implements ExternalItemService {

    @Override
    public ItemDO getItem(Long itemId) {
        return null;
    }
}
