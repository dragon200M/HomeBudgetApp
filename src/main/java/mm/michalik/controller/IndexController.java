package mm.michalik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maciej on 10.09.16.
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("")
    public String index() {


        return "index";
    }
}
