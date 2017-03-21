package com.iag.api.controller;

import com.iag.annotation.AuthorityCheck;
import com.iag.annotation.ControllerLog;
import com.iag.api.model.ApiResult;
import com.iag.controller.BaseController;
import com.iag.enums.log.SystemLog;
import com.iag.exception.ex.ApiBusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by xueshan.wei on 3/21/2017.
 */
@Api(value = "comments", description = "回复相关")
@Controller(value = "apiCommentsController")
@RequestMapping(value = "/api")
public class CommentsController extends BaseController {

    /**
     * 发布回复
     * @param pid 帖子id
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/posts/{pid}/comments", method = RequestMethod.POST)
    @ApiOperation(value = "发布评论", notes = "用于发布评论",
            response = ApiResult.class, httpMethod = "POST")
    @ControllerLog(log = SystemLog.DEFAULT)
    @AuthorityCheck
    public void addComments(@PathVariable Integer pid) throws ApiBusinessException{

    }
}
