package ltd.colingting.application.cqe;

import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月15日 15:20
 */
@Data
public class OrderQuery {
    private Long sellerId;
    private Long itemId;
    private int currentPage;
    private int pageSize;
}
