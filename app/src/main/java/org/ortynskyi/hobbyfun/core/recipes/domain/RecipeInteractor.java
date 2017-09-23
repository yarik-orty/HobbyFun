package org.ortynskyi.hobbyfun.core.recipes.domain;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.base.mvp.Food2ForkInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import java.util.List;

import rx.Observable;

public abstract class RecipeInteractor extends Food2ForkInteractor {

    public abstract Observable<List<Recipe>> fetchRecipes(@NonNull final String query, final int page);
}
