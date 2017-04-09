package com.iag.api.model.transfer;

import com.iag.api.model.ApiPosts;
import com.iag.model.IagPosts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beishan on 2017/4/8.
 */
public class PostsTransfer {

    public static List<ApiPosts> ToApiPostss(List<IagPosts> postss){
        if (postss != null && postss.size() > 0){
            List<ApiPosts> list = new ArrayList<ApiPosts>();
            ApiPosts apiPosts = null;
            for(IagPosts posts : postss){
                apiPosts = new ApiPosts(posts);
                list.add(apiPosts);
            }
            return list;
        }
        return null;
    }
}
