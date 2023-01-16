package ltd.colingting.application.dto;

import lombok.Data;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月01日 13:16
 */
@Data
public class OrderDTO implements Identifier {

    private Long id;

    private String itemTitle;

    private String detailAddress;
}
