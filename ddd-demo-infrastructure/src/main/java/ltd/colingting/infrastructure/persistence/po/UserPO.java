package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年07月24日 15:40
 */
@Data
@TableName("user")
public class UserPO {

    @TableId
    private Long id;

    private String name;

    private String phone;

    private String address;

    private Long repId;

}
