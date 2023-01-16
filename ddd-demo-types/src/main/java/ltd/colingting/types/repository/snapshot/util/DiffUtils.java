package ltd.colingting.types.repository.snapshot.util;

import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.repository.Identifier;
import ltd.colingting.types.repository.snapshot.EntityDiff;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:49
 */

public class DiffUtils {
    public static <T extends Aggregate<ID>, ID extends Identifier> EntityDiff diff(T snapshot, T aggregate) {
        return null;
    }
}
