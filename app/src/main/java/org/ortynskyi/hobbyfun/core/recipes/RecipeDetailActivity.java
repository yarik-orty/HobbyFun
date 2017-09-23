package org.ortynskyi.hobbyfun.core.recipes;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.BaseActivity;

public final class RecipeDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);
        final String recipeId = getIntent().getStringExtra(RecipeListFragment.EXTRA_RECIPE_ID);
        replaceFragment(RecipeDetailFragment.newInstance(recipeId), false);
    }
}
