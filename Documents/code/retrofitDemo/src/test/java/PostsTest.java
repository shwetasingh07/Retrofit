import API.DemoAPI;
import models.GetPostsResponse;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by shweta.singh on 28/01/18.
 */
public class PostsTest {

    private static DemoAPI serviceGenerator;

    public PostsTest() throws IOException {
        serviceGenerator = new DemoAPI();
    }

    @Test
    public void getPosts()
    {
        Response<GetPostsResponse> response = serviceGenerator.getPosts();
        GetPostsResponse posts = response.body();
        System.out.println(posts.getUserId() + " + " + posts.getId() + " + " +posts.getTitle() + " + " + posts.getBody());
    }
}
