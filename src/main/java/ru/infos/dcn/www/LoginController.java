package ru.infos.dcn.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.infos.dcn.server.service.UserAuthenticationService;

/**
 * @author Andrey Tsvetkov
 */
@Controller
public class LoginController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    /**
     * Creates login.htm
     *
     * @return login.htm
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doLogin() {
        return new ModelAndView("login.htm");
    }

    /**
     * Performers login.htm
     *
     * @param login login
     * @param password password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processLogin(@RequestParam
                                     String login,
                                     @RequestParam
                                     String password) {
        if (userAuthenticationService.authenticateUser(login, password)) {
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("error.htm");
        }

    }

}
