package org.ortynskyi.hobbyfun.base.mvp;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.network.RestApi;

public abstract class Food2ForkInteractor implements BaseInteractor {

    private final static String RECIPE_API_KEY = "5f9725ae1f5409fabf719c623efea677";

    @NonNull
    @Override
    public RestApi getRestApi() {
        return RestApi.getInstance();
    }

    @NonNull
    @Override
    public String getAccessToken() {
        return RECIPE_API_KEY;
    }
}
