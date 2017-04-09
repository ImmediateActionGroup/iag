package com.iag.controller;

import com.iag.exception.ex.BusinessException;
import com.iag.model.IagPosts;
import com.iag.util.db.DataPage;
import com.iag.validate.commons.PageQuery;
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
    public ModelAndView queryAll(PageQuery pageQuery) throws BusinessException{
        ModelAndView mv = new ModelAndView("article");
        DataPage<IagPosts> page = new DataPage<IagPosts>();
        page.setOffsetLimit(pageQuery.getOffset(), pageQuery.getLimit());
        serviceManager.getPostsService().page(page);
        mv.addObject("page", page);
        return mv;
    }
}
