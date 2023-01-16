package ltd.colingting.external.dto;

import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:02
 */
// 自定义的内部值类
@Data
public class ItemDTO {

    private Long itemId;
    private Long sellerId;
    private String title;
    private Long priceInCents;

}
