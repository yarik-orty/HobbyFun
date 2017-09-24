package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractorImpl;
import org.ortynskyi.hobbyfun.utils.Logger;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public final class RecipePresenterImpl implements RecipePresenter {

    private static final String TAG = "RecipePresenterImpl";

    private final CompositeSubscription subscriptions = new CompositeSubscription();
    private final RecipeInteractor interactor;
    private RecipeView view;

    public RecipePresenterImpl() {
        interactor = new RecipeInteractorImpl();
    }

    @Override
    public void fetchRecipes(@NonNull final String searchQuery, final int page) {
        view.showProgress(true);
        subscriptions.add(interactor.fetchRecipes(searchQuery, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recipes -> view.loadRecipes(recipes),
                        e -> Logger.d(TAG, "onError: " + e.getMessage()), () -> view.showProgress(false)));
    }

    @Override
    public void onDestroy() {
        subscriptions.unsubscribe();
    }

    @Override
    public void attachView(@NonNull final RecipeView view) {
        this.view = view;
    }
}
