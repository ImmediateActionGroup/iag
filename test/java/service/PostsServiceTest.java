package service;

import base.BaseTest;
import com.iag.enums.PostsEditType;
import com.iag.validate.ValidatePosts;
import org.junit.Test;

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
}
