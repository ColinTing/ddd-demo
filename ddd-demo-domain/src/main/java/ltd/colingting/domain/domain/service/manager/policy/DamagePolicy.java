package ltd.colingting.domain.domain.service.manager.policy;

import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;

/**
 * @author 丁浩
 * @date 2022年09月08日 10:03
 */

public interface DamagePolicy {

    boolean canApply(Player player, Weapon weapon, Monster monster);

    int calculateDamage(Player player, Weapon weapon, Monster monster);
}
