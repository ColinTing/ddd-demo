package ltd.colingting.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.colingting.domain.vo.RepId;

/**
 * @author 丁浩
 * @date 2022年07月24日 13:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesRep {
    private RepId repId;
}
