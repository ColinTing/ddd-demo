package ltd.colingting.domain.domain.service;

import java.util.ArrayList;
import java.util.List;
import ltd.colingting.domain.domain.entity.Movable;
import ltd.colingting.types.types.Transform;
import ltd.colingting.types.types.Vector;
import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月13日 16:01
 */

@Component
public class MovementSystem {

    private static final long X_FENCE_MIN = -100;
    private static final long X_FENCE_MAX = 100;
    private static final long Y_FENCE_MIN = -100;
    private static final long Y_FENCE_MAX = 100;

    private List<Movable> entities = new ArrayList<>();

    public void register(Movable movable) {
        entities.add(movable);
    }

    public void update() {
        for (Movable entity : entities) {
            if (!entity.isMoving()) {
                continue;
            }

            Transform old = entity.getPosition();
            Vector vel = entity.getVelocity();
            long newX = Math.max(Math.min(old.getX() + vel.getX(), X_FENCE_MAX), X_FENCE_MIN);
            long newY = Math.max(Math.min(old.getY() + vel.getY(), Y_FENCE_MAX), Y_FENCE_MIN);
            entity.moveTo(newX, newY);
        }
    }

}
