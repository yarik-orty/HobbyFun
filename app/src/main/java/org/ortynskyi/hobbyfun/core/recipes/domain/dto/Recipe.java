package org.ortynskyi.hobbyfun.core.recipes.domain.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Recipe {

    @SerializedName("recipe_id") private String recipeId;
    @SerializedName("source_url") private String sourceUrl;
    @SerializedName("f2f_url") private String f2fUrl;
    @SerializedName("publisher") private String publisher;
    @SerializedName("publisher_url") private String publisherUrl;
    @SerializedName("social_rank") private float socialRank;
    @SerializedName("image_url") private String imageUrl;
    @SerializedName("title") private String title;
    @SerializedName("ingredients") private List<String> ingredients;

    public String getRecipeId() {
        return recipeId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getF2fUrl() {
        return f2fUrl;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public float getSocialRank() {
        return socialRank;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
