package org.library.demo.controllerDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String home(){
        System.out.println("***********Ritorno stringa 'home' || HomeController.home--12");
        return "home";

    }                   /**
                          * ogni volta che si riceve una richiesta con metodo GET e verso /home
                          * ritorna una String "home".
                          * Questa stringa viene raccolta AUTOMATICAMENTE dal viewResolver
                          * che gestisce prefisso e suffisso
                          */
}
