package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.network.RecipeApi;
import org.ortynskyi.hobbyfun.network.RestApi;
import org.ortynskyi.hobbyfun.network.model.recipe.RecipeDetailWrapper;
import org.ortynskyi.hobbyfun.utils.Constants;

import rx.Observable;

public final class RecipeDetailInteractorImpl implements RecipeDetailInteractor {

    private final RecipeApi api;

    public RecipeDetailInteractorImpl() {
        this.api = RestApi.createRecipeApi();
    }

    @Override
    public Observable<Recipe> fetchRecipe(@NonNull final String recipeId) {
        return api.fetchRecipe(Constants.RECIPE_API_KEY, recipeId).map(RecipeDetailWrapper::getRecipe);
    }
}
