package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BasePresenter;

public interface RecipePresenter extends BasePresenter<RecipeView> {

    void fetchRecipes(@NonNull final String searchQuery);
}
