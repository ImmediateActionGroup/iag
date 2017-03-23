package service;

import base.BaseTest;
import com.iag.enums.PostsEditType;
import com.iag.model.IagPosts;
import com.iag.validate.ValidatePosts;
import org.junit.Test;

import java.util.List;

/**
 * Created by beishan on 2017/3/22.
 */
public class PostsServiceTest extends BaseTest {

    @Test
    public void add() throws Exception{
        ValidatePosts posts = new ValidatePosts();
        posts.setTitle("这是标题");
        posts.setEditType(PostsEditType.RICHTEXT.value());
        posts.setContent("这是内容");
        posts.setBid(1);

        serviceManager.getPostsService().addPosts(1, posts);
    }

    @Test
    public void queryAll() throws Exception{
        List<IagPosts> postss = serviceManager.getPostsService().queryAll();
        for(IagPosts posts : postss){
            System.out.println(posts.getId() + "----" + posts.getTitle()
                + "----" + posts.getContent() + "----" + posts.getPublishTime());
        }
    }
}
