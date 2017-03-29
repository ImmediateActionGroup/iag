package com.iag.api.controller;

import com.iag.annotation.AuthorityCheck;
import com.iag.annotation.ControllerLog;
import com.iag.api.model.ApiResult;
import com.iag.controller.BaseController;
import com.iag.enums.log.SystemLog;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.BusinessException;
import com.iag.model.IagComments;
import com.iag.model.IagUser;
import com.iag.validate.ValidateComments;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by xueshan.wei on 3/21/2017.
 */
@Api(value = "comments", description = "回复相关")
@Controller(value = "apiCommentsController")
@RequestMapping(value = "/api")
public class CommentsController extends BaseController {

    /**
     * 发布回复
     * @param comments
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ApiOperation(value = "发布评论", notes = "用于发布评论",
            response = ApiResult.class, httpMethod = "POST")
    @ControllerLog(log = SystemLog.DEFAULT)
    @AuthorityCheck
    public void addComments(@Valid @RequestBody ValidateComments comments, BindingResult bindingResult) throws ApiBusinessException{
        if(bindingResult.hasErrors()){
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        IagUser currentUser = getCurrentUser();
        try {
            IagComments newComm = serviceManager.getCommentsService().addComments(currentUser.getId(), comments.getPid(),
                            comments.getParentId(), comments.getContent());
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }
}
