package ltd.colingting.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年08月17日 14:46
 */
@Data
@TableName("account")
public class AccountPO {

    @TableId
    private Long id;
    private long accountNumber;
    private long userId;
    private BigDecimal available;
    private BigDecimal dailyLimit;
    private String currency;

}
