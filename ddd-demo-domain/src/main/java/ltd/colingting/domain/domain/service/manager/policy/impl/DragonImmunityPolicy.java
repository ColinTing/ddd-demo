package ltd.colingting.domain.domain.service.manager.policy.impl;

import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.service.manager.policy.DamagePolicy;

/**
 * @author 丁浩
 * @date 2022年09月08日 10:11
 */

public class DragonImmunityPolicy implements DamagePolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() != PlayerClass.Dragoon &&
            monster.getMonsterClass() == MonsterClass.Dragon;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return 0;
    }
}
