package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeDetailInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeDetailInteractorImpl;
import org.ortynskyi.hobbyfun.utils.Logger;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public final class RecipeDetailPresenterImpl implements RecipeDetailPresenter {

    private static final String TAG = "RecipeDetailPresenterIm";

    private final CompositeSubscription subscriptions = new CompositeSubscription();
    private final RecipeDetailInteractor interactor;
    private RecipeDetailView view;

    public RecipeDetailPresenterImpl() {
        interactor = new RecipeDetailInteractorImpl();
    }

    @Override
    public void getRecipe(@NonNull final String recipeId) {
        view.showProgress(true);
        subscriptions.add(interactor.fetchRecipe(recipeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recipe -> view.loadRecipe(recipe),
                        e -> Logger.d(TAG, "onError: " + e.getMessage()), () -> view.showProgress(false)));
    }

    @Override
    public void onDestroy() {
        subscriptions.unsubscribe();
    }

    @Override
    public void attachView(@NonNull final RecipeDetailView view) {
        this.view = view;
    }
}
