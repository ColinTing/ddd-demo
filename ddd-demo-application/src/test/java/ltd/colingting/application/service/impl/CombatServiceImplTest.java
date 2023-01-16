package ltd.colingting.application.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import ltd.colingting.application.config.SwordProto;
import ltd.colingting.application.config.WeaponPrototype;
import ltd.colingting.application.service.factory.MonsterFactory;
import ltd.colingting.application.service.factory.PlayerFactory;
import ltd.colingting.application.service.factory.WeaponFactory;
import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.entity.Weapon;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.service.CombatService;
import ltd.colingting.domain.domain.service.EquipmentService;
import ltd.colingting.domain.repository.WeaponRepository;
import ltd.colingting.types.types.Health;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CombatServiceImplTest extends TestCase {


    @Autowired
    private CombatService combatService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private WeaponRepository weaponRepository;


    @Autowired
    private SwordProto swordProto;

    @Autowired
    private WeaponPrototype weaponPrototype;

    @Test
    @DisplayName("Dragoon attack dragon doubles damage")
    public void testDragoonSpecial() {
        // Given
        Player dragoon = PlayerFactory.createPlayer(PlayerClass.Dragoon, "Dart");
        Weapon sword = WeaponFactory.createWeaponFromPrototype(swordProto, "Soul Eater", 60);
        weaponRepository.cache(sword);
        dragoon.equip(sword, equipmentService);
        Monster dragon = MonsterFactory.createMonster(MonsterClass.Dragon, 100);

        // When
        combatService.performAttack(dragoon, dragon);

        // Then
        assertThat(dragon.getHealth()).isEqualTo(Health.ZERO);
        assertThat(dragon.isAlive()).isFalse();
    }

    @Test
    @DisplayName("Orc should receive half damage from physical weapons")
    public void testFighterOrc() {
        // Given
        Player fighter = PlayerFactory.createPlayer(PlayerClass.Fighter, "MyFighter");
        Weapon sword = WeaponFactory.createWeaponFromPrototype(weaponPrototype, "My Sword");
        weaponRepository.cache(sword);
        fighter.equip(sword, equipmentService);
        Monster orc = MonsterFactory.createMonster(MonsterClass.Orc, 100);

        // When
        combatService.performAttack(fighter, orc);

        // Then
        assertThat(orc.getHealth()).isEqualTo(Health.of((long) (100 - 10 / 2)));
    }
}