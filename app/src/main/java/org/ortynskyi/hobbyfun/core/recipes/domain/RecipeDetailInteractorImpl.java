package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.network.RecipeApi;
import org.ortynskyi.hobbyfun.network.model.recipe.RecipeDetailWrapper;

import rx.Observable;

public final class RecipeDetailInteractorImpl extends RecipeDetailInteractor {

    private final RecipeApi api;

    public RecipeDetailInteractorImpl() {
        this.api = getRestApi().createRecipeApi();
    }

    @Override
    public Observable<Recipe> fetchRecipe(@NonNull final String recipeId) {
        return api.fetchRecipe(getAccessToken(), recipeId).map(RecipeDetailWrapper::getRecipe);
    }
}
