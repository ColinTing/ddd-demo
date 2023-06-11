package ltd.colingting.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.entity.User;
import ltd.colingting.domain.repository.UserRepository;
import ltd.colingting.infrastructure.assemble.EntityAssemble;
import ltd.colingting.infrastructure.persistence.mapper.UserMapper;
import ltd.colingting.infrastructure.persistence.po.UserPO;
import org.springframework.stereotype.Service;

/**
 * @author 丁浩
 * @date 2022年07月24日 15:27
 */
@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {


    private final UserMapper userMapper;


    private final EntityAssemble entityAssemble;

    @Override
    public User saveUser(User user) {
        UserPO userPO = entityAssemble.toUserPO(user);
        userMapper.insert(userPO);
        return user;
    }
}
