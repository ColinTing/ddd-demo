package ltd.colingting.domain.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.colingting.domain.vo.Address;
import ltd.colingting.domain.vo.Name;
import ltd.colingting.domain.vo.PhoneNumber;
import ltd.colingting.domain.vo.RepId;
import ltd.colingting.domain.vo.UserId;

/**
 * @author 丁浩
 * @date 2022年07月23日 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User  implements Serializable {

    private UserId userId;
    private Name name;
    private PhoneNumber phone;
    private Address address;
    private RepId repId;

}
