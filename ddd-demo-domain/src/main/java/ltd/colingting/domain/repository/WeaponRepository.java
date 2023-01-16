package ltd.colingting.domain.repository;

import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.types.types.WeaponId;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:05
 */

public interface WeaponRepository {

    Weapon find(WeaponId weaponId);

    void cache(Weapon sword);
}
