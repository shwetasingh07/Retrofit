import models.GetPostsResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Retrofit.Builder;

import java.io.IOException;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.http.Path;


public class TestRetrofitInOneClass {

    //https://jsonplaceholder.typicode.com/posts/1
    public interface Endpoints {
        @GET("posts/{postNumber}")
        Call<GetPostsResponse> getPosts(@Path("postNumber") String postNumber);

    }

    public static void main (String args[])
    {
        System.out.println("Welcome to Retrofit Demo");

        // set your desired log level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);

        //Create OkhttpClient
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        okhttpbuilder.addInterceptor(logging);

        //create Retrofit instance
        Retrofit retrofit = new Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();

        //Get Client to make the request
        Endpoints endpoints = retrofit.create(Endpoints.class);

        try {
            Response<GetPostsResponse> response = endpoints.getPosts("2").execute();
            GetPostsResponse posts = response.body();
            System.out.println(response.isSuccessful());
            System.out.println("RESPONSE CODE IS : " + response.code());
            System.out.println(posts.getUserId() + " + " + posts.getId() + " + " +posts.getTitle() + " + " + posts.getBody());
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }


}
