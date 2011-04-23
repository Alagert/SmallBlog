package ru.infos.dcn.www;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import ru.infos.dcn.common.dto.CommentDTO;
import ru.infos.dcn.server.service.BlogService;


public class ShowCommentsController implements Controller {
    BlogService blogService;


    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        final String postId = httpServletRequest.getParameter("postId");
        final List<CommentDTO> comments = blogService.getPostComments(Long.parseLong(postId));
        final ModelAndView view = new ModelAndView("showComments.htm");
        view.addObject("comments", comments);
        return view;
    }
}
