package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPosts;
import com.iag.model.IagResPer;
import com.iag.util.db.Conditions;
import com.iag.util.db.DataPage;
import com.iag.validate.ValidatePosts;

import java.util.List;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface PostsService {
    /**
     * 发表帖子
     * @param uid 用户id
     * @param posts 帖子数据实体
     * @return
     * @throws BusinessException
     */
    IagPosts addPosts(Integer uid, ValidatePosts posts) throws BusinessException;

    /**
     * 分页查询帖子
     * @param page
     * @throws BusinessException
     */
    void page(DataPage<IagPosts> page) throws BusinessException;

    /**
     * 分页条件查询帖子
     * @param page
     * @param conditions
     * @throws BusinessException
     */
    void page(DataPage<IagPosts> page, Conditions conditions) throws BusinessException;

    /**
     * query all posts
     * @return
     * @throws DataBaseException
     */
    List<IagPosts> queryAll() throws DataBaseException;

    /**
     * 查询某个帖子
     * @param pid
     * @return
     * @throws DataBaseException
     */
    IagPosts queryById(Integer pid) throws DataBaseException;

    /**
     * query a posts
     * @param pid
     * @return
     * @throws BusinessException
     */
    IagPosts querySinglePosts(Integer pid);

    /**
     * 删除帖子
     * @param pid
     * @throws BusinessException
     */
    void deletePosts(Integer pid) throws BusinessException;
}
