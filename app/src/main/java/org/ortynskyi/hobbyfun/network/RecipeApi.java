package org.ortynskyi.hobbyfun.network;

import org.ortynskyi.hobbyfun.network.model.recipe.RecipeDetailWrapper;
import org.ortynskyi.hobbyfun.network.model.recipe.RecipeWrapper;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RecipeApi {

    @GET("get")
    Observable<RecipeDetailWrapper> fetchRecipe(@Query("key") final String key,
                                                @Query("rId") final String id);

    @GET("search")
    Observable<RecipeWrapper> searchRecipeList(@Query("key") final String key,
                                               @Query("q") final String name);

    @GET("search")
    Observable<RecipeWrapper> searchRecipeList(@Query("key") final String key,
                                               @Query("q") final String name,
                                               @Query("page") final int page);
}
