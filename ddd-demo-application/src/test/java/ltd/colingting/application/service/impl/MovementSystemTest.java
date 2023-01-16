package ltd.colingting.application.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lombok.extern.slf4j.Slf4j;
import ltd.colingting.application.service.factory.MonsterFactory;
import ltd.colingting.application.service.factory.PlayerFactory;
import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.service.MovementSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class MovementSystemTest {

    @Autowired
    private MovementSystem movementSystem;

    @Test
    @DisplayName("Moving player and monster at the same time")
    public void testMovement() {
        // Given
        Player fighter = PlayerFactory.createPlayer(PlayerClass.Fighter, "MyFighter");
        fighter.moveTo(2, 5);
        fighter.startMove(1, 0);

        Monster orc = MonsterFactory.createMonster(MonsterClass.Orc, 100);
        orc.moveTo(10, 5);
        orc.startMove(-1, 0);

        movementSystem.register(fighter);
        movementSystem.register(orc);

        // When
        movementSystem.update();

        // Then
        assertThat(fighter.getPosition().getX()).isEqualTo(2 + 1);
        assertThat(orc.getPosition().getX()).isEqualTo(10 - 1);
    }

}