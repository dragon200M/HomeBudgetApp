package mm.michalik.service.springData;

import mm.michalik.commands.UserForm;
import mm.michalik.converters.UserFormToUser;
import mm.michalik.converters.UserToUserForm;
import mm.michalik.domain.User;
import mm.michalik.repository.UserRepository;
import mm.michalik.service.UserService;
import mm.michalik.service.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciej on 01.09.16.
 */
@Service
public class UserRepositoryImpl implements UserService {

    @Override
    public User saveOrUpdate(User domainObject) {
        return null;
    }

    private UserRepository userRepository;
    private EncryptionService encryptionService;
    private UserFormToUser userFormToUser;
    private UserToUserForm toForm;

    @Autowired
    public void setToForm(UserToUserForm toForm) {
        this.toForm = toForm;
    }

    @Autowired
    public void setUserFormToUser(UserFormToUser userFormToUser) {
        this.userFormToUser = userFormToUser;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
       List<User> userList=new ArrayList<>();
        userRepository.findAll().forEach(userList::add);


        return userList;
    }

    @Override
    public User getById(Integer id) {

        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdateUserForm(UserForm domainObject) {
        User newUser=userFormToUser.convert(domainObject);

        if(newUser.getPassword()!=null)
        {
            newUser.setEncryptedPassword(encryptionService.encryptString(newUser.getPassword()));

        }

        return userRepository.save(newUser);
    }

    @Override
    public void delete(Integer id) {
            userRepository.delete(id);
    }


    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    public UserForm getByIdForm(Integer id) {
       UserForm usr=toForm.convert(getById(id));

        return usr;
    }
}
