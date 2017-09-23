package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;
import android.util.Log;

import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractorImpl;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.utils.Constants;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class RecipePresenterImpl implements RecipePresenter {

    private static final String TAG = "RecipePresenterImpl";

    private final RecipeInteractor interactor;
    private RecipeView view;

    public RecipePresenterImpl() {
        interactor = new RecipeInteractorImpl();
    }

    @Override
    public void fetchRecipes(@NonNull final String searchQuery) {
        interactor.fetchRecipes(Constants.RECIPE_API_KEY, searchQuery)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Recipe>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onComplete");
                    }

                    @Override
                    public void onError(final Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(final List<Recipe> recipes) {
                        view.loadRecipes(recipes);
                    }
                });
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(final RecipeView view) {
        this.view = view;
    }
}
