package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:19
 */
@Data
@TableName("line_item")
public class LineItemPO {

    private Long id;

    private Long orderId;

    private Long itemId;

    private int quantity;

    private BigDecimal price;

}
