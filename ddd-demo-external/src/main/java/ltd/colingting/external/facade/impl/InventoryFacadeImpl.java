package ltd.colingting.external.facade.impl;

import javax.annotation.Resource;
import ltd.colingting.external.client.ExternalInventoryService;
import ltd.colingting.external.facade.InventoryFacade;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:29
 * 库存Facade实现
 */
@Service
public class InventoryFacadeImpl implements InventoryFacade {

    @Resource
    private ExternalInventoryService externalInventoryService;

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return externalInventoryService.withhold(itemId, quantity);
    }
}
