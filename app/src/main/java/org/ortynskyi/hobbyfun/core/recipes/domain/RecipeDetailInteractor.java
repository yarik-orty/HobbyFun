package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.Food2ForkInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import rx.Observable;

public abstract class RecipeDetailInteractor extends Food2ForkInteractor {

    public abstract Observable<Recipe> fetchRecipe(@NonNull final String recipeId);
}
