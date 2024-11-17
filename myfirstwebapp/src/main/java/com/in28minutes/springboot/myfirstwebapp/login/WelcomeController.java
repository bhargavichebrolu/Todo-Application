package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
// private Logger logger = LoggerFactory.getLogger(getClass());
   // @RequestMapping("login")
    // URL: http://localhost:8080/login?name=bhargavi
    /*public String goToLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        System.out.println("name is "+name);
        logger.info("Request Parameter is {}", name); 
        logger.debug("hello");// Use logger instead of System.out.println
        return "login";*/
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String goToWelcomePage(ModelMap model) {
	   model.put("name", "getLoggedInUsername()");
       return "welcome";
   }
private String getLoggedInUsername() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
}
	
}