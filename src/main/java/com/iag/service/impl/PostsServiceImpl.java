package com.iag.service.impl;

import com.iag.enums.ModelIsDelete;
import com.iag.enums.ModelIsOrNot;
import com.iag.enums.PostsEditType;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagBoard;
import com.iag.model.IagPosts;
import com.iag.model.IagUser;
import com.iag.service.PostsService;
import com.iag.util.db.Conditions;
import com.iag.util.db.DataPage;
import com.iag.validate.ValidatePosts;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("postsService")
public class PostsServiceImpl extends BaseService<IagPosts> implements PostsService {

    public IagPosts queryById(Integer pid) throws DataBaseException {
        return (IagPosts) baseDAO.queryById(com.iag.model.IagPosts.class, pid);
    }

    public IagPosts querySinglePosts(Integer pid){
        IagPosts posts = null;
        try {
            posts = queryById(pid);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        if(posts != null && posts.getIsDelete() == ModelIsDelete.NOT_DELETE.value()){
            return posts;
        } else {
            return null;
        }
    }

    private Integer savePosts(IagPosts posts) throws DataBaseException{
        return baseDAO.save(posts);
    }
    public IagPosts addPosts(Integer uid, ValidatePosts posts) throws BusinessException {
        // TODO: 2017/3/22  
        IagPosts newPosts = new IagPosts();
        IagUser user = new IagUser();
        user.setId(uid);
        newPosts.setUser(user);
        IagBoard board = new IagBoard();
        board.setId(posts.getBid());
        newPosts.setBoard(board);
        newPosts.setTitle(posts.getTitle());
        newPosts.setContent(posts.getContent());
        newPosts.setEditType(PostsEditType.getPET(posts.getEditType()).value());
        newPosts = initPosts(newPosts);
        Integer newId = savePosts(newPosts);
        return (IagPosts) baseDAO.queryById(com.iag.model.IagPosts.class, newId);
    }
    private IagPosts initPosts(IagPosts posts){
        posts.setIsDelete(ModelIsDelete.NOT_DELETE.value());
        posts.setIsHidden(ModelIsOrNot.NOT.value());
        posts.setPraiseNum(0);
        posts.setPublishTime(new Date());
        posts.setViewNum(0);

        return posts;
    }
    public void page(DataPage<IagPosts> page) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("isDelete",
                ModelIsDelete.NOT_DELETE.value(),
                Conditions.Operator.EQUAL);
        conditions.addOrderBy("publishTime", false);
        this.page(page, conditions);
    }

    public void page(DataPage<IagPosts> page, Conditions conditions) throws BusinessException {
        baseDAO.page(page, com.iag.model.IagPosts.class, conditions);
    }

    public List<IagPosts> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagPosts.class);
    }

    public void deletePosts(Integer pid) throws BusinessException {
        IagPosts posts = queryById(pid);
        if(posts != null){
            posts.setIsDelete(ModelIsDelete.DELETE.value());
            baseDAO.update(posts);
        }else {
            throw new BusinessException(ExceptionEnum.POST_NOT_EXIST);
        }
    }
}
