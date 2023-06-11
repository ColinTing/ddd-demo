package ltd.colingting.types.types;

import lombok.Value;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月02日 11:04
 */
@Value
public class OrderId implements Identifier {

    Long id;

}
