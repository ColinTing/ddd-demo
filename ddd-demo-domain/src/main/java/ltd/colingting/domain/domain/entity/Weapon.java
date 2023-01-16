package ltd.colingting.domain.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ltd.colingting.domain.domain.enums.WeaponType;
import ltd.colingting.types.types.WeaponId;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:08
 */
@Data
@AllArgsConstructor
public class Weapon {

    private WeaponId id;
    private String name;
    private WeaponType weaponType; // enum
    private int damage;
    private int damageType; // 0 - physical, 1 - fire, 2 - ice

}
