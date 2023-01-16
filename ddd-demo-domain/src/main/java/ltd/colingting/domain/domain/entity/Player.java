package ltd.colingting.domain.domain.entity;


import lombok.Data;
import ltd.colingting.domain.domain.enums.PlayerClass;
import ltd.colingting.domain.domain.service.EquipmentService;
import ltd.colingting.types.types.PlayerId;
import ltd.colingting.types.types.Transform;
import ltd.colingting.types.types.Vector;
import ltd.colingting.types.types.WeaponId;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:04
 */
@Data
public class Player implements Movable {
    private PlayerId id;
    private String name;
    private PlayerClass playerClass; // enum
    private WeaponId weaponId; // （Note 1）
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    public void equip(Weapon weapon, EquipmentService equipmentService) {
        if (equipmentService.canEquip(this, weapon)) {
            this.weaponId = weapon.getId();
        } else {
            throw new IllegalArgumentException("Cannot Equip: " + weapon);
        }
    }


    @Override
    public Transform getPosition() {
        return null;
    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void moveTo(long x, long y) {
        this.position = new Transform(x, y);
    }

    @Override
    public void startMove(long velocityX, long velocityY) {
        this.velocity = new Vector(velocityX, velocityY);
    }

    @Override
    public void stopMove() {
        this.velocity = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.velocity.getX() != 0 || this.velocity.getY() != 0;
    }
}
