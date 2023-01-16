package ltd.colingting.domain.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Player extends Movable{

//    @Setter(AccessLevel.PROTECTED)
    private Weapon weapon;


    public void attack(Monster monster) {
        monster.receiveDamageBy(weapon, this);
    }
}
