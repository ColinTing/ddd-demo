package ltd.colingting.types.repository.snapshot.util;

import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:50
 */

public class SnapshotUtils {

    public static <T extends Aggregate<ID>, ID extends Identifier> T snapshot(T aggregate) {
        return null;
    }
}
