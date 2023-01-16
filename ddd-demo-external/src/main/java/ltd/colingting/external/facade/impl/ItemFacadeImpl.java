package ltd.colingting.external.facade.impl;

import javax.annotation.Resource;
import ltd.colingting.external.client.ExternalItemService;
import ltd.colingting.external.dto.ItemDTO;
import ltd.colingting.external.facade.ItemFacade;
import ltd.colingting.external.persistence.ItemDO;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:04
 * 商品facade实现
 */
@Service
public class ItemFacadeImpl implements ItemFacade {

    @Resource
    private ExternalItemService externalItemService;

    @Override
    public ItemDTO getItem(Long itemId) {
        ItemDO itemDO = externalItemService.getItem(itemId);
        if (itemDO != null) {
            ItemDTO dto = new ItemDTO();
            dto.setItemId(itemDO.getItemId());
            dto.setTitle(itemDO.getTitle());
            dto.setPriceInCents(itemDO.getPriceInCents());
            dto.setSellerId(itemDO.getSellerId());
            return dto;
        }
        return null;
    }
}
