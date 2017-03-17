package info.androidhive.gmail.network;

/**
 * Created by Ravi Tamada on 21/02/17.
 * www.androidhive.info
 */


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
//    public static final String BASE_URL = "http://api.androidhive.info/json/";
    public static final String BASE_URL = "http://10.0.2.2/test-api/";
    private static Retrofit retrofit = null;
    
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
