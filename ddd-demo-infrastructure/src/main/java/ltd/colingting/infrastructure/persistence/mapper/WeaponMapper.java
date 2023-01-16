package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.WeaponPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 丁浩
 * @date 2022年09月07日 11:14
 */

@Mapper
public interface WeaponMapper extends BaseMapper<WeaponPO> {

}
