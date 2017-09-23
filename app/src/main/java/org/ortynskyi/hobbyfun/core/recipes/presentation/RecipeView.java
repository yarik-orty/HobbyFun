package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BaseView;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import java.util.List;

public interface RecipeView extends BaseView {

    void loadRecipes(@NonNull final List<Recipe> recipes);
}
