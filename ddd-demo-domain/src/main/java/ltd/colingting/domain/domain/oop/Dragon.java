package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Dragon extends Monster {

    private final String name;

    public Dragon(String name, Long health) {
        this.name = name;
        super.health = health;
    }

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (weapon instanceof Gun) { // 新的逻辑
            super.receiveDamageBy(weapon, player);
        }
        if (player instanceof Dragoon) {
            this.setHealth(this.getHealth() - weapon.getDamage() * 2); // 龙骑伤害规则
        }
        // else no damage, 龙免疫力规则
    }

}
