package com.granitosdearena.matiaslev.cocktails.presentation.CocktailPreviewRecycler

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import kotlinx.android.synthetic.main.item_cocktail_preview.view.*

class CocktailPreviewViewHolder(val context: Context, itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindTo(cocktailPreview: CocktailPreview?) = cocktailPreview?.let {
        itemView.drinkName.text = it.drinkName
        Glide.with(context).load(it.drinkThumb).thumbnail(0.1f).into(itemView.drinkThumb)
    }
}