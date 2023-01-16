package ltd.colingting.types.repository.snapshot.util;

import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:51
 */

public class ReflectionUtils {

    public static <T extends Aggregate<ID>, ID extends Identifier> void writeField(String idField, T aggregate, ID id) {

    }

}
