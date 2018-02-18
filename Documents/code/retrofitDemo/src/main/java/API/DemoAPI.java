package API;

import endpoints.PostsEndpoints;
import models.GetPostsResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import Retrofit.RetrofitClient;

public class DemoAPI {

    private final PostsEndpoints endpoints;

    public DemoAPI() {
        Retrofit retrofit = new Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(RetrofitClient.buildClient())
                .build();
        endpoints = retrofit.create(PostsEndpoints.class);
    }


    public Response<GetPostsResponse> getPosts()
    {
        Response<GetPostsResponse> response = null;
        try {
            response = endpoints.getPosts("2").execute();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }

}
