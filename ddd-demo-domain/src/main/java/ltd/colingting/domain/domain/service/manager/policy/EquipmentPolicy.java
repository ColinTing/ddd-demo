package ltd.colingting.domain.domain.service.manager.policy;

import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;

/**
 * @author 丁浩
 * @date 2022年09月07日 10:21
 */

public interface EquipmentPolicy {
    boolean canApply(Player player, Weapon weapon);

    boolean canEquip(Player player, Weapon weapon);

}
