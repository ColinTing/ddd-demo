package ltd.colingting.domain.domain.service.manager.policy.impl;

import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.service.manager.policy.DamagePolicy;

/**
 * @author 丁浩
 * @date 2022年09月08日 10:12
 */

public class ElfResistancePolicy implements DamagePolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() == PlayerClass.Mage &&
            monster.getMonsterClass() == MonsterClass.Elf;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() / 2;
    }
}
