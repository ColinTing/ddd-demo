package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月01日 10:47
 */
@Data
@TableName("order")
public class OrderPO {
    @TableId
    private Long id;

    private String itemId;

    private String addressDetail;

}
