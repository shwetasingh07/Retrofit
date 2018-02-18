package interceptors;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class ResponseCodeInterceptor implements Interceptor{

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (!response.isSuccessful()) {
            System.out.println(String.format("RESPONSE FAILED WITH RESONSE CODE = %s for request : %s", response.code(), request));
        }
        if(response.code() == 200)
        {
            System.out.println("Response is ========================== 200");
        }
        return response;
    }
}
