package ltd.colingting.domain.repository;

import ltd.colingting.domain.domain.entity.Item;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:43
 */

public interface ItemRepository {


    Item find(Long itemId);
}
