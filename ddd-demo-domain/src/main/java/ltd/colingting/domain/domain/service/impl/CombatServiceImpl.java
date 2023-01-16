package ltd.colingting.domain.domain.service.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.service.CombatService;
import ltd.colingting.domain.domain.service.manager.DamageManager;
import ltd.colingting.domain.repository.WeaponRepository;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:02
 */
@RequiredArgsConstructor
@Service
public class CombatServiceImpl implements CombatService {

    private final WeaponRepository weaponRepository;
    private final DamageManager damageManager;

    @Override
    public void performAttack(Player player, Monster monster) {
        Weapon weapon = weaponRepository.find(player.getWeaponId());
        int damage = damageManager.calculateDamage(player, weapon, monster);
        if (damage > 0) {
            monster.takeDamage(damage); // （Note 1）在领域服务里变更Monster
        }
        // 省略掉Player和Weapon可能受到的影响
    }

}
