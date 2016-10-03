package mm.michalik.converters;

import mm.michalik.commands.UserForm;
import mm.michalik.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by maciej on 09.09.16.
 */
@Component
public class UserToUserForm implements Converter<User,UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm=new UserForm();
        userForm.setFirstName(user.getName());
        userForm.setLastName(user.getLastname());
        userForm.setUserName(user.getUsername());
        userForm.setUserVersion(user.getVersion());
        userForm.setPasswordText("");
        userForm.setPasswordTextConf("");
        userForm.setUserId(user.getId());
        userForm.setUserEmail(user.getEmail());

        return userForm;
    }
}
