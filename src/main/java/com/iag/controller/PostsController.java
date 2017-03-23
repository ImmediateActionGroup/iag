package com.iag.controller;

import com.iag.exception.ex.BusinessException;
import com.iag.model.IagPosts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xueshan.wei on 3/23/2017.
 */
@Controller
public class PostsController extends BaseController {

    @RequestMapping(value = "/posts")
    public ModelAndView queryAll() throws BusinessException{
        ModelAndView mv = new ModelAndView("postss");
        List<IagPosts> postss = serviceManager.getPostsService().queryAll();
        mv.addObject("postss", postss);
        return mv;
    }
}
