package ltd.colingting.external.client.fallback;

import ltd.colingting.external.client.ExternalInventoryService;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:32
 */

public class ExternalInventoryFallback implements ExternalInventoryService {

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return false;
    }
}
