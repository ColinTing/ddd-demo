package ltd.colingting.infrastructure.repository.assemble;

import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.enums.WeaponType;
import ltd.colingting.infrastructure.persistence.po.WeaponPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:26
 */

@Mapper(componentModel = "spring")
public interface WeaponAssembler {




    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "weaponType", source = "weaponType")
    })
    Weapon toWeapon(WeaponPO weaponDO);

    @Mappings({
        @Mapping(target = "id", source = "id.id"),
        @Mapping(target = "weaponType", source = "weaponType")
    })
    WeaponPO fromWeapon(Weapon weapon);

    default WeaponType map(int value) {
        return WeaponType.getTypeById(value);
    }

    default int map(WeaponType value) {
        return WeaponType.getIdByType(value);
    }
}
