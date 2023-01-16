package ltd.colingting.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.repository.WeaponRepository;
import ltd.colingting.infrastructure.persistence.mapper.WeaponMapper;
import ltd.colingting.infrastructure.persistence.po.WeaponPO;
import ltd.colingting.infrastructure.repository.assemble.WeaponAssembler;
import ltd.colingting.types.types.WeaponId;
import org.springframework.stereotype.Repository;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:11
 */
@Repository
@RequiredArgsConstructor
public class WeaponRepositoryImpl implements WeaponRepository {


    private final WeaponMapper weaponDAO;

    private final WeaponAssembler weaponAssembler;

    @Override
    public Weapon find(WeaponId weaponId) {
        WeaponPO orderDO = weaponDAO.selectById(weaponId.getId());
        return weaponAssembler.toWeapon(orderDO);
    }

    @Override
    public void cache(Weapon sword) {
        WeaponPO weaponPO = weaponAssembler.fromWeapon(sword);
        weaponDAO.insert(weaponPO);
    }
}
