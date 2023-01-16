package ltd.colingting.domain.domain.entity;

import lombok.Data;
import ltd.colingting.domain.domain.enums.MonsterClass;
import ltd.colingting.types.types.Health;
import ltd.colingting.types.types.MonsterId;
import ltd.colingting.types.types.Transform;
import ltd.colingting.types.types.Vector;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:07
 */
@Data
public class Monster implements Movable {

    private MonsterId id;
    private MonsterClass monsterClass; // enum
    private Health health;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

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

    }

    @Override
    public void startMove(long velX, long velY) {

    }

    @Override
    public void stopMove() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    public void takeDamage(int damage) {
        health.setHealth(health.getHealth() - damage);
    }

    public boolean isAlive() {
        return health.getHealth() > 0;

    }
}
