package ltd.colingting.domain.domain.service.manager;

import java.util.ArrayList;
import java.util.List;
import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.service.manager.policy.DamagePolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.DefaultDamagePolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.DragonImmunityPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.DragoonPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.ElfResistancePolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.OrcResistancePolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.PhysicalDamagePolicy;
import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:06
 */
// 策略优先级管理
@Component
public class DamageManager {
    private static final List<DamagePolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new DragoonPolicy());
        POLICIES.add(new DragonImmunityPolicy());
        POLICIES.add(new OrcResistancePolicy());
        POLICIES.add(new ElfResistancePolicy());
        POLICIES.add(new PhysicalDamagePolicy());
        POLICIES.add(new DefaultDamagePolicy());
    }

    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        for (DamagePolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon, monster)) {
                continue;
            }
            return policy.calculateDamage(player, weapon, monster);
        }
        return 0;
    }
}
