package org.ortynskyi.hobbyfun.network;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import org.ortynskyi.hobbyfun.network.rx.RxErrorCallAdapterFactory;
import org.ortynskyi.hobbyfun.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitManager {

    private RetrofitManager() {}

    private static final GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(
            new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create());

    private static final OkHttpClient.Builder httpClient = getHttpClient();

    @NonNull
    public static final Retrofit recipeRetrofit = new Retrofit.Builder()
            .baseUrl(Constants.RECIPE_BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxErrorCallAdapterFactory.create())
            .build();

    @NonNull
    private static OkHttpClient.Builder getHttpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
        return httpClient;
    }

    static {
        if (true) { // todo add condition
            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addNetworkInterceptor(logging);
        }
    }
}
