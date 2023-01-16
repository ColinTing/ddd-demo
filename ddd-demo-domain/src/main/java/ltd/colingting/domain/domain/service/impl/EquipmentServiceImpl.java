package ltd.colingting.domain.domain.service.impl;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.service.EquipmentService;
import ltd.colingting.domain.domain.service.manager.EquipmentManager;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年09月07日 10:14
 */
@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentManager equipmentManager;
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return equipmentManager.canEquip(player, weapon);
    }
}
