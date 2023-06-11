package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年07月23日 18:37
 */
@Data
@TableName("sales_rep")
public class SalesRepPO {
    @TableId
    private String areaCode;

    private Long repId;
}
