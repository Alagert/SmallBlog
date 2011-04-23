package ru.infos.dcn.www;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.infos.dcn.server.service.BlogService;


public class HomeController implements Controller {
    private BlogService blogService;


    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        final ModelAndView view = new ModelAndView("home.htm");
        view.addObject("users", blogService.getAllUsers());
        return view;
    }
}
