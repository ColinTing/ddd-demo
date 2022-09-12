package ltd.colingting.application.assemble;

import ltd.colingting.application.dto.ItemDTO;
import ltd.colingting.application.dto.OrderDTO;
import ltd.colingting.domain.domain.entity.Item;
import ltd.colingting.domain.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年09月01日 11:21
 */
@Mapper(componentModel = "spring")
public interface DtoAssembler {


    // 通过各种实体，生成DTO
    @Mappings({
        @Mapping(target = "id", source = "order.id.id"),
        @Mapping(target = "itemTitle", source = "item.title"),
        @Mapping(target = "detailAddress", source = "order.address.detail"),
    })
    OrderDTO toDTO(Order order, Item item);

    // 通过DTO，生成实体
    Item toEntity(ItemDTO itemDTO);
}
