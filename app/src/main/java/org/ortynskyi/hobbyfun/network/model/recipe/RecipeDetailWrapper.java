package org.ortynskyi.hobbyfun.network.model.recipe;

import com.google.gson.annotations.SerializedName;

import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

public final class RecipeDetailWrapper {

    @SerializedName("recipe") private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }
}
