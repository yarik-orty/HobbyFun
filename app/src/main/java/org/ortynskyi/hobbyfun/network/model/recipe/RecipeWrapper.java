package org.ortynskyi.hobbyfun.network.model.recipe;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import java.util.List;

public final class RecipeWrapper {

    @SerializedName("count") private int count;
    @SerializedName("recipes") private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    @NonNull
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
