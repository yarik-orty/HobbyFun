package org.ortynskyi.hobbyfun.core.recipes;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.BaseActivity;

public final class RecipeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        replaceFragment(new RecipeListFragment(), false);
    }
}
