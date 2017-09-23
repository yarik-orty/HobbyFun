package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BasePresenter;

public interface RecipeDetailPresenter extends BasePresenter<RecipeDetailView> {

    void getRecipe(@NonNull final String recipeId);
}
