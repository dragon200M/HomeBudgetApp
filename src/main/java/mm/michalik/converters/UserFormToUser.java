package mm.michalik.converters;


import mm.michalik.commands.UserForm;
import mm.michalik.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by maciej on 02.09.16.
 */
@Component
public class UserFormToUser implements Converter<UserForm,User>{

    @Override
    public User convert(UserForm userForm) {

        User user=new User();

        user.setLastname(userForm.getLastName());
        user.setName(userForm.getLastName());
        user.setUsername(userForm.getUserName());
        user.setId(userForm.getUserId());
        user.setPassword(userForm.getPasswordText());
        user.setVersion(userForm.getUserVersion());
        user.setEmail(userForm.getUserEmail());

        return user;
    }
}
