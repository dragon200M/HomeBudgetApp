package mm.michalik.repository;

import mm.michalik.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by maciej on 01.09.16.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);

}
