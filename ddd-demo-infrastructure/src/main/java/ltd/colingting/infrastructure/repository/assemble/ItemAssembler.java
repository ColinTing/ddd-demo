package ltd.colingting.infrastructure.repository.assemble;

import ltd.colingting.domain.domain.entity.Item;
import ltd.colingting.infrastructure.persistence.po.ItemDetailPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:25
 */
@Mapper(componentModel = "spring")
public interface ItemAssembler {




    @Mappings({
        @Mapping(target = "id", source = "itemId")
    })
    Item toItem(ItemDetailPO itemDetailPO);
}
