package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.ItemDetailPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 丁浩
 * @date 2022年09月01日 17:09
 */
@Mapper
public interface ItemMapper extends BaseMapper<ItemDetailPO> {

}
