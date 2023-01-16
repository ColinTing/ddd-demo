package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Monster extends Movable {
    Long health;


    public void receiveDamageBy(Weapon weapon, Player player) {
        this.health -= weapon.getDamage(); // 基础规则
        if (weapon instanceof Gun) { // 新的逻辑
            this.setHealth(0L);
        }
    }
}
