package com.iag.service.impl;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagComments;
import com.iag.model.IagPosts;
import com.iag.model.IagUser;
import com.iag.service.CommentsService;
import com.iag.service.PostsService;
import com.iag.validate.ValidateComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("commentsService")
public class CommentsServiceImpl extends BaseService<IagComments> implements CommentsService {
    @Autowired
    private PostsService postsService;

    private Integer saveComments(IagComments comments) throws DataBaseException{
        return baseDAO.save(comments);
    }
    public IagComments addComments(Integer uid, Integer pid, Integer parentId, String content) throws BusinessException {
        //检查回复的帖子是否存在
        IagPosts posts = postsService.queryById(pid);
        if(posts == null){
            throw new BusinessException(ExceptionEnum.POST_NOT_EXIST);
        }
        //如果传过来的父id为0 则代表这个回复没有父回复
        IagComments commentsTemp = null;
        if(parentId != 0){
            //检查父节点id是否存在
            commentsTemp = queryById(parentId);
            if(commentsTemp == null){
                throw new BusinessException(ExceptionEnum.COMM_ADD_PARENT_NOTEXIST);
            }
        }
        //初始化回复内容
        IagComments newComm = new IagComments();
        newComm.setContent(content);
        newComm.setBadNum(0);
        newComm.setComments(commentsTemp);
        newComm.setPosts(posts);
        newComm.setPraiseNum(0);
        newComm.setPublishTime(new Date());

        IagUser user = new IagUser();
        user.setId(uid);
        newComm.setUser(user);

        Integer newId = saveComments(newComm);
        return queryById(newId);
    }

    public List<IagComments> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagComments.class);
    }

    public IagComments queryById(Integer cid) throws DataBaseException {
        return (IagComments) baseDAO.queryById(com.iag.model.IagComments.class, cid);
    }
}
