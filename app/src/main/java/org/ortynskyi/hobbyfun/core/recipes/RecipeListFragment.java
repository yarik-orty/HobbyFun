package org.ortynskyi.hobbyfun.core.recipes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.BaseFragment;
import org.ortynskyi.hobbyfun.core.recipes.adapter.RecipeAdapter;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.core.recipes.presentation.RecipePresenter;
import org.ortynskyi.hobbyfun.core.recipes.presentation.RecipePresenterImpl;
import org.ortynskyi.hobbyfun.core.recipes.presentation.RecipeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class RecipeListFragment extends BaseFragment implements RecipeView {

    private static final String PIZZA = "pizza";

    @BindView(R.id.recipesRecycle) RecyclerView recipesRecycle;

    private RecipePresenter presenter;

    private RecipeAdapter adapter;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RecipePresenterImpl();
        presenter.attachView(this);
    }

    @NonNull
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        presenter.fetchRecipes(PIZZA);
        return view;
    }

    @Override
    public void loadRecipes(@NonNull final List<Recipe> recipes) {
        adapter.setRecipes(recipes);
    }

    private void initAdapter() {
        adapter = new RecipeAdapter();
        recipesRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recipesRecycle.setAdapter(adapter);
    }
}
