package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;
import android.util.Log;

import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeDetailInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeDetailInteractorImpl;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class RecipeDetailPresenterImpl implements RecipeDetailPresenter {

    private static final String TAG = "RecipeDetailPresenterIm";

    private final RecipeDetailInteractor interactor;
    private RecipeDetailView view;

    public RecipeDetailPresenterImpl() {
        interactor = new RecipeDetailInteractorImpl();
    }

    @Override
    public void getRecipe(@NonNull final String recipeId) {
        interactor.fetchRecipe(recipeId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Recipe>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(final Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(final Recipe recipe) {
                view.loadRecipe(recipe);
            }
        });
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(@NonNull final RecipeDetailView view) {
        this.view = view;
    }
}
