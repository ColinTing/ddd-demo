package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 丁浩
 * @date 2022年07月24日 15:43
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
