package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.network.RecipeApi;
import org.ortynskyi.hobbyfun.network.model.recipe.RecipeWrapper;

import java.util.List;

import rx.Observable;

public final class RecipeInteractorImpl extends RecipeInteractor {

    private final RecipeApi api;

    public RecipeInteractorImpl() {
        api = getRestApi().createRecipeApi();
    }

    @Override
    public Observable<List<Recipe>> fetchRecipes(@NonNull final String query) {
        return api.searchRecipeList(getAccessToken(), query).map(RecipeWrapper::getRecipes);
    }
}
