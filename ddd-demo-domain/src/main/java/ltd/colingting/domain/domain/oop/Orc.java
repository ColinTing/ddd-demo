package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Orc extends Monster {

    private final String name;

    public Orc(String name, Long health) {
        this.name = name;
        super.health = health;
    }

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (weapon.getDamageType() == 0) {
            this.setHealth(this.getHealth() - weapon.getDamage() / 2); // Orc的物理防御规则
        } else {
            super.receiveDamageBy(weapon, player);
        }
    }

}
