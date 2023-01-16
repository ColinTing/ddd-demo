package ltd.colingting.application.service.factory;

import ltd.colingting.domain.domain.entity.Monster;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.types.types.Health;

/**
 * @author 丁浩
 * @date 2022年09月08日 16:46
 */

public class MonsterFactory {

    public static Monster createMonster(MonsterClass monsterClass, long health) {

        Monster monster = new Monster();
        monster.setMonsterClass(monsterClass);
        monster.setHealth(new Health(health));
        return monster;
    }
}
