package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:13
 */
@Data
@TableName("weapon")
public class WeaponPO {

    @TableId
    private Long id;

    private String name;

    private int weaponType;

    private int damage;

    private int damageType;

}
