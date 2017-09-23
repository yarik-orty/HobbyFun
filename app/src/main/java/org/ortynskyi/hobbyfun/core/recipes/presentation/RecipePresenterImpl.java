package org.ortynskyi.hobbyfun.core.recipes.presentation;

import android.support.annotation.NonNull;
import android.util.Log;

import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractor;
import org.ortynskyi.hobbyfun.core.recipes.domain.RecipeInteractorImpl;

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
    public void fetchRecipes(@NonNull final String searchQuery) {
        subscriptions.add(interactor.fetchRecipes(searchQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recipes -> view.loadRecipes(recipes),
                        e -> Log.d(TAG, "onError: " + e.getMessage()), () -> Log.d(TAG, "onComplete")));
    }

    @Override
    public void onDestroy() {
        subscriptions.unsubscribe();
    }

    @Override
    public void attachView(final RecipeView view) {
        this.view = view;
    }
}
