package ltd.colingting.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.entity.Item;
import ltd.colingting.domain.repository.ItemRepository;
import ltd.colingting.infrastructure.persistence.mapper.ItemMapper;
import ltd.colingting.infrastructure.persistence.po.ItemDetailPO;
import ltd.colingting.infrastructure.repository.assemble.ItemAssembler;
import org.springframework.stereotype.Repository;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:45
 */
@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemMapper itemDAO;

    private final ItemAssembler itemAssembler;


    @Override
    public Item find(Long itemId) {
        ItemDetailPO itemDetailPO = itemDAO.selectById(itemId);

        return itemAssembler.toItem(itemDetailPO);
    }
}
