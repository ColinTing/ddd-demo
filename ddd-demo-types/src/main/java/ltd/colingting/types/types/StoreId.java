package ltd.colingting.types.types;

import lombok.Value;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月02日 13:28
 */
@Value
public class StoreId implements Identifier {

    Long id;

}
