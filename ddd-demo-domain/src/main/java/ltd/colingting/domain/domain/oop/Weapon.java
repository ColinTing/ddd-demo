package ltd.colingting.domain.domain.oop;

import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:35
 */
@Data
public abstract class Weapon {
    int damage;
    int damageType; // 0 - physical, 1 - fire, 2 - ice etc.
}
