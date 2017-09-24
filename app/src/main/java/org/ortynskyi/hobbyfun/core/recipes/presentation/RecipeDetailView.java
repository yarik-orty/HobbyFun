package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BaseView;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

public interface RecipeDetailView extends BaseView {

    void loadRecipe(@NonNull final Recipe recipe);
}
