package interceptors;
import okhttp3.logging.HttpLoggingInterceptor;

public class LoggingInterceptor {

    public static HttpLoggingInterceptor getLoggingInterceptor(String logLevel)
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.valueOf(logLevel));
        return logging;
    }

}
