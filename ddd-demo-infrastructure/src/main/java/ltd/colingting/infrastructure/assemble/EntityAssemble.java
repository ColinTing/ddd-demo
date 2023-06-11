package ltd.colingting.infrastructure.assemble;


import ltd.colingting.domain.entity.SalesRep;
import ltd.colingting.domain.entity.User;
import ltd.colingting.infrastructure.persistence.po.SalesRepPO;
import ltd.colingting.infrastructure.persistence.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author 丁浩
 * @date 2022年07月24日 15:47
 */
@Mapper(componentModel = "spring")
public interface EntityAssemble {
    EntityAssemble INSTANCE = Mappers.getMapper(EntityAssemble.class);

    @Mappings({
        @Mapping(target = "id", source = "userId.userId"),
        @Mapping(target = "name", source = "name.name"),
        @Mapping(target = "phone", source = "phone.number"),
        @Mapping(target = "address", source = "address.address"),
        @Mapping(target = "repId", source = "repId.repId")
    })
    UserPO toUserPO(User user);

    @Mapping(target = "repId.repId", source = "repId")
    SalesRep toSalesRep(SalesRepPO salesRepPO);

}
