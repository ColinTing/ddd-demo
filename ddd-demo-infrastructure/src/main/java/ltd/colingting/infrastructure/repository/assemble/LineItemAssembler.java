package ltd.colingting.infrastructure.repository.assemble;

import ltd.colingting.domain.domain.entity.LineItem;
import ltd.colingting.infrastructure.persistence.po.LineItemPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:22
 */
@Mapper(componentModel = "spring")
public interface LineItemAssembler {



    @Mappings({
        @Mapping(target = "id", source = "id.id"),
        @Mapping(target = "orderId", source = "orderId.id"),
        @Mapping(target = "itemId", source = "itemId.id"),
        @Mapping(target = "quantity", source = "quantity.quantity")
    })
    LineItemPO fromLineItem(LineItem lineItem);

    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "orderId.id", source = "orderId"),
        @Mapping(target = "itemId.id", source = "itemId"),
        @Mapping(target = "quantity.quantity", source = "quantity")
    })
    LineItem toLineItem(LineItemPO lineItemDO);
}
