package ltd.colingting.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.colingting.infrastructure.persistence.po.AccountPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 丁浩
 * @date 2022年08月17日 14:40
 */

@Mapper
public interface AccountMapper extends BaseMapper<AccountPO> {

    @Select("select * from account where account_number = #{value}")
    AccountPO selectByAccountNumber(String value);

    @Select("select * from account where user_id = #{id}")
    AccountPO selectByUserId(long id);
}
