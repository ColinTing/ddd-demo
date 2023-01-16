package ltd.colingting.domain.domain.entity;

import ltd.colingting.types.types.Transform;
import ltd.colingting.types.types.Vector;

/**
 * @author 丁浩
 * @date 2022年09月07日 09:42
 */

public interface Movable {
    // 相当于组件
    Transform getPosition();
    Vector getVelocity();

    // 行为
    void moveTo(long x, long y);
    void startMove(long velX, long velY);
    void stopMove();
    boolean isMoving();
}
