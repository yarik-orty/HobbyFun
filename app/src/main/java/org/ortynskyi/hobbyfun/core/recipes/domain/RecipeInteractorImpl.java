package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.network.RecipeApi;
import org.ortynskyi.hobbyfun.network.RestApi;
import org.ortynskyi.hobbyfun.network.model.recipe.RecipeWrapper;

import java.util.List;

import rx.Observable;

public final class RecipeInteractorImpl implements RecipeInteractor {

    private final RecipeApi api;

    public RecipeInteractorImpl() {
        api = RestApi.createRecipeApi();
    }

    @Override
    public Observable<List<Recipe>> fetchRecipes(@NonNull final String key, @NonNull final String query) {
        return api.searchRecipeList(key, query).map(RecipeWrapper::getRecipes);
    }
}
