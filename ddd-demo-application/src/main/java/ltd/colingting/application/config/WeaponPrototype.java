package ltd.colingting.application.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import ltd.colingting.domain.domain.enums.WeaponType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author 丁浩
 * @date 2022年09月13日 15:42
 */
@ConstructorBinding
@ConfigurationProperties(prefix = WeaponPrototype.PREFIX)
@Data
@Setter(AccessLevel.PRIVATE)
public class WeaponPrototype {

    static final String PREFIX = "weapon-proto";

    private final WeaponType weaponType = WeaponType.Sword;

    private final int damageType = 0;

    private final int damage = 60;
}
