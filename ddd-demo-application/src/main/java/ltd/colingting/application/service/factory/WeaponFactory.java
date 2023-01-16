package ltd.colingting.application.service.factory;

import ltd.colingting.application.config.SwordProto;
import ltd.colingting.application.config.WeaponPrototype;
import ltd.colingting.domain.domain.entity.Weapon;

/**
 * @author 丁浩
 * @date 2022年09月08日 16:38
 */

public class WeaponFactory {


    public static Weapon createWeaponFromPrototype(SwordProto swordProto, String name, int damage){

        return new Weapon(null, name, swordProto.getWeaponType(), damage, swordProto.getDamageType());
    }

    public static Weapon createWeaponFromPrototype(WeaponPrototype proto, String newName) {

        return new Weapon(null, newName, proto.getWeaponType(), proto.getDamage(), proto.getDamageType());
    }

}
