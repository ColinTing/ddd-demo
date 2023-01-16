package ltd.colingting.domain.domain.service.manager.policy.impl;

import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.enums.WeaponType;
import ltd.colingting.domain.domain.service.manager.policy.EquipmentPolicy;

/**
 * @author 丁浩
 * @date 2022年09月07日 10:28
 */

public class DefaultEquipmentPolicy implements EquipmentPolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon) {
        return player.getPlayerClass() == PlayerClass.Fighter;
    }

    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return weapon.getWeaponType() == WeaponType.Sword
            || weapon.getWeaponType() == WeaponType.Dagger;
    }
}
