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
     * Performers login.do
     *
     * @param login    login
     * @param password password
     * @return redirects to home.htm in success case, instead to error.htm
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doLogin(
            @RequestParam
            String login,
            @RequestParam
            String password
    ) {
        if (userAuthenticationService.authenticateUser(login, password)) {
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("error.htm");
        }
    }

}
