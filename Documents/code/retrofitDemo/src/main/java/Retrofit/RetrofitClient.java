package Retrofit;

import interceptors.LoggingInterceptor;
import interceptors.ResponseCodeInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.*;

public class RetrofitClient {

    public static OkHttpClient buildClient()
    {
        return new Builder()
                .addInterceptor(LoggingInterceptor.getLoggingInterceptor("BODY"))
                .addInterceptor(new ResponseCodeInterceptor())
                .build();
    }

}
