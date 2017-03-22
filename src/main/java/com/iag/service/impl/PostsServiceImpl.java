package com.iag.service.impl;

import com.iag.enums.ModelIsDelete;
import com.iag.enums.ModelIsOrNot;
import com.iag.enums.PostsEditType;
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

/**
 * Created by beishan on 2017/3/8.
 */
@Service("postsService")
public class PostsServiceImpl extends BaseService<IagPosts> implements PostsService {

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

    }

    public void page(DataPage<IagPosts> page, Conditions conditions) throws BusinessException {

    }
}
