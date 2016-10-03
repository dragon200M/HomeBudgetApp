package mm.michalik.controller;

import mm.michalik.commands.UserForm;
import mm.michalik.domain.User;
import mm.michalik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by maciej on 01.09.16.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new UserForm());


        return "/user/form";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(UserForm userForm){



        User newUser=userService.saveOrUpdateUserForm(userForm);


        return "redirect:user/"+newUser.getId();
    }


    @RequestMapping("/{id}")
    public String getUserByID(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getByIdForm(id));

        return "/user/show";
    }
}
