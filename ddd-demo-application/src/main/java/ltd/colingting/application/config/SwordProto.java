package ltd.colingting.application.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import ltd.colingting.domain.domain.enums.WeaponType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author 丁浩
 * @date 2022年09月08日 17:27
 */
@ConstructorBinding
@ConfigurationProperties(prefix = SwordProto.PREFIX)
@Data
@Setter(AccessLevel.PRIVATE)
public class SwordProto {

    static final String PREFIX = "sword-proto";

    private final WeaponType weaponType = WeaponType.Sword;

    private final int damageType = 0;

}
