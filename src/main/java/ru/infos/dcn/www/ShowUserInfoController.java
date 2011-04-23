package ru.infos.dcn.www;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.server.service.BlogService;


public class ShowUserInfoController implements Controller {
    BlogService blogService;

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        final String userNick = httpServletRequest.getParameter("userNick");
        final ModelAndView view = new ModelAndView("showUser.htm");
        final UserDTO userDTO = blogService.getUser(userNick);
        view.addObject("user",userDTO);
        return view;
    }
}
