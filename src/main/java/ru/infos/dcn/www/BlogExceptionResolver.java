package ru.infos.dcn.www;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogExceptionResolver extends SimpleMappingExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) {
        final ModelAndView view = super.resolveException(httpServletRequest, httpServletResponse, object, exception);
        view.addObject("msg", exception.getMessage());
        return view;
    }
}
