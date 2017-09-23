package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BaseInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import rx.Observable;

public interface RecipeDetailInteractor extends BaseInteractor {

    Observable<Recipe> fetchRecipe(@NonNull final String recipeId);
}
