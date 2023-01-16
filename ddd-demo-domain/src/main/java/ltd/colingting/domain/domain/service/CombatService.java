package ltd.colingting.domain.domain.service;

import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:01
 * 攻击行为
 */

public interface CombatService {

    void performAttack(Player player, Monster monster);

}
