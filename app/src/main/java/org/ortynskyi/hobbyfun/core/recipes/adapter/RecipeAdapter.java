package org.ortynskyi.hobbyfun.core.recipes.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.core.recipes.domain.dto.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeAdapter() {}

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Recipe recipe = recipes.get(position);
        holder.recipeTitle.setText(recipe.getTitle());
        holder.recipeRating.setText(String.valueOf(recipe.getSocialRank()));
        Picasso.with(holder.itemView.getContext()).load(recipe.getImageUrl()).into(holder.recipeImage);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setRecipes(@NonNull final List<Recipe> recipes) {
        this.recipes.addAll(recipes);
        notifyDataSetChanged();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipeCard) CardView recipeCard;
        @BindView(R.id.recipeTitle) TextView recipeTitle;
        @BindView(R.id.recipeRating) TextView recipeRating;
        @BindView(R.id.recipeImage) ImageView recipeImage;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            recipeCard.setOnClickListener(
                    view -> Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show());
        }
    }
}
