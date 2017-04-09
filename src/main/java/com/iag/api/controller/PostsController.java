package com.iag.api.controller;

import com.iag.annotation.AuthorityCheck;
import com.iag.api.controller.base.ApiBaseController;
import com.iag.api.model.ApiPosts;
import com.iag.api.model.ApiResult;
import com.iag.api.model.commons.ApiPage;
import com.iag.api.model.transfer.PostsTransfer;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPosts;
import com.iag.util.db.DataPage;
import com.iag.validate.commons.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by beishan on 2017/3/19.
 */
@Api(value = "posts", description = "帖子相关")
@Controller("apiPostsController")
@RequestMapping(value = "/api")
public class PostsController extends ApiBaseController {

    /**
     * 分页查询帖子
     *
     * @param pageQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/postss", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询帖子", notes = "",
            httpMethod = "GET", response = ApiPage.class)
    @AuthorityCheck
    public void queryPosts(PageQuery pageQuery) throws ApiBusinessException {

        DataPage<IagPosts> page = new DataPage<IagPosts>();
        page.setOffsetLimit(pageQuery.getOffset(),
                pageQuery.getLimit());
        try {
            serviceManager.getPostsService().page(page);
            //转换成要输出的内容
            ApiPage apiPage = new ApiPage(page.getLimit(),
                    page.getOffset(),
                    page.getRows(),
                    PostsTransfer.ToApiPostss(page.getData()));

            this.apiResult.reset();
            this.apiResult.setApiResult("查询文章成功！", apiPage);
            this.renderResult();
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 查询单个帖子
     *
     * @param pid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/posts/{pid}", method = RequestMethod.GET)
    @ApiOperation(value = "查询单个帖子", notes = "",
            httpMethod = "GET", response = ApiPosts.class)
    @AuthorityCheck
    public void querySinglePosts(@PathVariable Integer pid) throws ApiBusinessException {
        IagPosts posts = null;
        posts = serviceManager.getPostsService().querySinglePosts(pid);

        if (posts != null) {
            ApiPosts apiPosts = new ApiPosts(posts);
            this.renderResult("查询帖子成功", apiPosts);
        } else {
            throw new ApiBusinessException(ExceptionEnum.POST_NOT_EXIST);
        }
    }

    @RequestMapping(value = "/posts/{pid}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除单个帖子", notes = "",
            httpMethod = "DELETE", response = ApiResult.class)
    @AuthorityCheck
    public void deleteSinglePosts(@PathVariable Integer pid) throws ApiBusinessException {
        try {
            serviceManager.getPostsService().deletePosts(pid);
            this.renderResult("删除帖子成功！");
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }
}
