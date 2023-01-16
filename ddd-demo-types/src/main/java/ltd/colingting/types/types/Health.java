package ltd.colingting.types.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 丁浩
 * @date 2022年09月06日 17:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {

    public static final Health ZERO = new Health(0L);

    Long health;

    public static Health of(Long i) {
        return new Health(i);
    }
}
