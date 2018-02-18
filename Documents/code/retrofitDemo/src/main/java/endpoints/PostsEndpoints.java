package endpoints;

import models.GetPostsResponse;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by shweta.singh on 27/01/18.
 */
public interface PostsEndpoints {

    @GET("posts/{postNumber}")
    Call<GetPostsResponse> getPosts(@Path("postNumber") String postNumber);

}
