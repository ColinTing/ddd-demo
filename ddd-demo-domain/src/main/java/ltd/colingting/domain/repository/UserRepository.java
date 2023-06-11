package ltd.colingting.domain.repository;

import ltd.colingting.domain.entity.User;

/**
 * @author 丁浩
 * @date 2022年07月23日 18:50
 */
public interface UserRepository {

    User saveUser(User user);
}
