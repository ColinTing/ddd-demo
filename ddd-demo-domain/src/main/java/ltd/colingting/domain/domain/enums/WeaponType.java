package ltd.colingting.domain.domain.enums;

import java.util.Arrays;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:49
 */

public enum WeaponType {
    Sword(0),
    Staff(1),
    Gun(2),
    Dagger(3);

    private final Integer id;



    WeaponType(Integer id) {
        this.id = id;
    }

    public static WeaponType getTypeById(Integer typeId) {
        return Arrays.stream(WeaponType.values())
            .filter(weaponTypeValue -> weaponTypeValue.id.equals(typeId))
            .findFirst()
            .orElse(null);
    }

    public static Integer getIdByType(WeaponType weaponType) {
        return weaponType.getId();
    }

    public Integer getId(){
        return this.id;
    }
}
