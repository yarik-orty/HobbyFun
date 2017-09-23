package org.ortynskyi.hobbyfun.network;

import org.ortynskyi.hobbyfun.network.model.recipe.RecipeWrapper;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RecipeApi {

//    @GET("get")
//    Observable<RecipeResponse> fetchRecipe(@Query("key") String key,
//                                           @Query("rId") String id);

    @GET("search")
    Observable<RecipeWrapper> searchRecipeList(@Query("key") String key,
                                               @Query("q") String name);

    @GET("search")
    Observable<RecipeWrapper> searchRecipeList(@Query("key") String key,
                                                     @Query("q") String name,
                                                     @Query("page") int page);
}
