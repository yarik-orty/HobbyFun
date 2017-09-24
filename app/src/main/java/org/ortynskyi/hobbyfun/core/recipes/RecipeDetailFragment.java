package org.ortynskyi.hobbyfun.core.recipes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.BaseFragment;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;
import org.ortynskyi.hobbyfun.core.recipes.presentation.RecipeDetailPresenterImpl;
import org.ortynskyi.hobbyfun.core.recipes.presentation.RecipeDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class RecipeDetailFragment extends BaseFragment implements RecipeDetailView {

    public static final String ARG_RECIPE_ID = "ARG_RECIPE_ID";

    @BindView(R.id.recipeImage) ImageView recipeImage;
    @BindView(R.id.recipeTitle) TextView recipeTitle;
    @BindView(R.id.recipeDescription) TextView recipeDescription;

    private RecipeDetailPresenterImpl presenter;

    @NonNull
    public static RecipeDetailFragment newInstance(@NonNull final String recipeId) {
        final RecipeDetailFragment fragment = new RecipeDetailFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_RECIPE_ID, recipeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || getArguments().getString(ARG_RECIPE_ID) == null) {
            throw new IllegalStateException("Fragment should be instantiated with newInstance method");
        }
        presenter = new RecipeDetailPresenterImpl();
        presenter.attachView(this);
    }

    @NonNull
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        final String recipeId = getArguments().getString(ARG_RECIPE_ID);
        presenter.getRecipe(recipeId);
        return view;
    }

    @Override
    public void loadRecipe(@NonNull final Recipe recipe) {
        Picasso.with(getContext()).load(recipe.getImageUrl()).into(recipeImage);
        recipeTitle.setText(recipe.getTitle());
        final StringBuilder ingredients = new StringBuilder();
        for (final String buffer : recipe.getIngredients()) {
            ingredients.append(buffer).append("\n");
        }
        recipeDescription.setText(ingredients);
    }
}
