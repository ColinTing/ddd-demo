package ltd.colingting.application.service.factory;

import ltd.colingting.domain.domain.entity.Player;
import ltd.colingting.domain.domain.enums.PlayerClass;

/**
 * @author 丁浩
 * @date 2022年09月08日 16:12
 */

public class PlayerFactory {

    public static Player createPlayer(){
        return new Player();
    }

    public static Player createPlayer(PlayerClass playerClass, String name) {

        Player player = new Player();
        player.setPlayerClass(playerClass);
        player.setName(name);

        return player;
    }
}
