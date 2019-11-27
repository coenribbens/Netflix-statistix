package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("defaultC")
public class DefaultController {

    // Index Page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {

        return "index";
    }
    
    // Index Redirect
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redirectIndex() {
        
        return "redirect:/";
    }

}