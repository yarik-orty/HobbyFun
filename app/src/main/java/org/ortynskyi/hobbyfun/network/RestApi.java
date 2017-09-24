package org.ortynskyi.hobbyfun.network;

import android.support.annotation.NonNull;

/**
 * RestApi for retrieving data from the network.
 */
public final class RestApi {

    public static final int DEFAULT_PAGE_SIZE = 50;
    public static final int DEFAULT_PAGE = 0;

    private static final class RestApiHolder {
        private static final RestApi INSTANCE = new RestApi();
    }

    private RestApi() {}

    @NonNull
    public static synchronized RestApi getInstance() {
        return RestApiHolder.INSTANCE;
    }

    @NonNull
    public RecipeApi createRecipeApi() {
        return RetrofitManager.recipeRetrofit.create(RecipeApi.class);
    }
}
