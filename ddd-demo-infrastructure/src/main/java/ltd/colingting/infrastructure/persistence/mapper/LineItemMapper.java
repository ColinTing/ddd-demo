package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.LineItemPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:35
 */
@Mapper
public interface LineItemMapper extends BaseMapper<LineItemPO> {

}
