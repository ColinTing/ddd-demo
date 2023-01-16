package ltd.colingting.domain.domain.service.manager;

import java.util.ArrayList;
import java.util.List;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.service.manager.policy.EquipmentPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.DefaultEquipmentPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.DragoonEquipmentPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.FighterEquipmentPolicy;
import ltd.colingting.domain.domain.service.manager.policy.impl.MageEquipmentPolicy;
import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月07日 10:15
 */
@Component
public class EquipmentManager {

    private static final List<EquipmentPolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new FighterEquipmentPolicy());
        POLICIES.add(new MageEquipmentPolicy());
        POLICIES.add(new DragoonEquipmentPolicy());
        POLICIES.add(new DefaultEquipmentPolicy());
    }

    public boolean canEquip(Player player, Weapon weapon) {
        for (EquipmentPolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon)) {
                continue;
            }
            return policy.canEquip(player, weapon);
        }
        return false;
    }

}
