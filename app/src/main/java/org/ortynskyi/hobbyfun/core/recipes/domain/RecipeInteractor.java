package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.BaseInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import java.util.List;

import rx.Observable;

public interface RecipeInteractor extends BaseInteractor {

    Observable<List<Recipe>> fetchRecipes(@NonNull final String key, @NonNull final String query);
}
