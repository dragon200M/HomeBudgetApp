package mm.michalik.service;

import mm.michalik.commands.UserForm;
import mm.michalik.domain.User;

/**
 * Created by maciej on 01.09.16.
 */
public interface UserService extends CrudService<User>{
    User getByUsername(String username);
    User saveOrUpdateUserForm(UserForm domainObject);
    UserForm getByIdForm(Integer id);
}
