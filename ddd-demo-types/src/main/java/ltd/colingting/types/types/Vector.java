package ltd.colingting.types.types;

import lombok.Value;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:39
 */

@Value
public class Vector {
    public static final Vector ZERO = new Vector(0, 0);
    long x;
    long y;
}
