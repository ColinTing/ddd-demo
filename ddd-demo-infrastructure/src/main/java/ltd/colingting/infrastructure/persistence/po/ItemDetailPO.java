package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:52
 */
@Data
@TableName("item_detail")
public class ItemDetailPO {

    @TableId
    private String itemId;

    private String title;

    private String description;
}
