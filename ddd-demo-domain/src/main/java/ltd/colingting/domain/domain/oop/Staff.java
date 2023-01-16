package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Staff extends Weapon {

    private final String name;

    public Staff(String name, int damage) {
        this.name = name;
        this.damageType = 1;
        this.damage = damage;
    }
}
