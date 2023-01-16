package ltd.colingting.types.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月02日 11:04
 */
@AllArgsConstructor
@Data
public class OrderId implements Identifier {

    Long id;

}
