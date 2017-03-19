package com.iag.api.controller;

import com.iag.api.controller.base.ApiBaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beishan on 2017/3/19.
 */
@Api(value = "posts", description = "帖子相关")
@Controller("apiPostsController")
@RequestMapping(value = "/api")
public class PostsController extends ApiBaseController {

}
