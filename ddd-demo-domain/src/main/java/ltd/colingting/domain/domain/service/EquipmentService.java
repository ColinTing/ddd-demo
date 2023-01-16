package ltd.colingting.domain.domain.service;

import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;

/**
 * @author 丁浩
 * @date 2022年09月07日 09:57
 * 装备行为
 */

public interface EquipmentService {
    boolean canEquip(Player player, Weapon weapon);
}
