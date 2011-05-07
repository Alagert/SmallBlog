package ru.infos.dcn.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.infos.dcn.server.service.UserAuthenticationService;
import ru.infos.dcn.www.dto.LoginDto;

/**
 * @author Andrey Tsvetkov
 */
@Controller
public class LoginController {

    private final static String ATTRIBUTE_NAME = "login";

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    /**
     * Creates login.htm
     *
     * @return login.htm
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView("login.htm");
        model.addObject(ATTRIBUTE_NAME, new LoginDto());
        return model;
    }

    /**
     * Performers login.htm
     *
     * @param loginDto a dto with login and password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processLogin(
            @ModelAttribute(value = ATTRIBUTE_NAME)
            LoginDto loginDto) {
        if (userAuthenticationService.authenticateUser(loginDto.getLogin(), loginDto.getPass())) {
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("error.htm");
        }

    }

}
