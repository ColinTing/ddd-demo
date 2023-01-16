package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Sword extends Weapon {

    private final String name;

    public Sword(String name, int damage) {
        this.name = name;
        super.damage = damage;
    }
}
