package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.OrderPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 丁浩
 * @date 2022年09月01日 10:40
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {


    @Select("select * from order where id = #{orderId} and item_id = #{storeId}")
    OrderPO findInStore(Long orderId, Long storeId);
}
