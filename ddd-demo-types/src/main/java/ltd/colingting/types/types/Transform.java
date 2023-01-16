package ltd.colingting.types.types;

import lombok.Value;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:35
 */
@Value
public class Transform {

    public static final Transform ORIGIN = new Transform(0, 0);
    long x;
    long y;

}
