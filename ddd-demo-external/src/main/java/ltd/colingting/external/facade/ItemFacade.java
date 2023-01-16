package ltd.colingting.external.facade;

import ltd.colingting.external.dto.ItemDTO;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:03
 * 商品Facade接口
 */

public interface ItemFacade {
    ItemDTO getItem(Long itemId);
}
