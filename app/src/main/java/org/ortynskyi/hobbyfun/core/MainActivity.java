package org.ortynskyi.hobbyfun.core;

import android.content.Intent;
import android.os.Bundle;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.BaseActivity;
import org.ortynskyi.hobbyfun.core.recipes.RecipeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.recipesButton)
    public void onClick() {
        final Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
