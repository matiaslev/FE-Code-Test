package com.granitosdearena.matiaslev.cocktails.presentation.CocktailPreviewRecycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.granitosdearena.matiaslev.cocktails.domain.CocktailPreview
import kotlinx.android.synthetic.main.item_cocktail_preview.view.*

class CocktailPreviewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindTo(cocktailPreview: CocktailPreview?) = cocktailPreview?.let {
        itemView.drinkName.text = it.drinkName
    }
}