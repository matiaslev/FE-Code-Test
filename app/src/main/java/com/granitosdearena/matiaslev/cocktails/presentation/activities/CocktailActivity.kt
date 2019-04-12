package com.granitosdearena.matiaslev.cocktails.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.granitosdearena.matiaslev.cocktails.R
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_cocktail.*
import kotlinx.android.synthetic.main.item_cocktail_preview.view.*
import org.koin.android.ext.android.get

class CocktailActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    companion object {
        val COCKTAIL_ID = "COCKTAIL_ID"

        fun getCocktailActivityIntent(context: Context, cocktailId: String): Intent {
            return Intent(context, CocktailActivity::class.java).apply {
                putExtra(COCKTAIL_ID, cocktailId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail)

        val cocktailViewModel: CocktailViewModel = get()

        disposable = cocktailViewModel.getCockailById(intent.getStringExtra(COCKTAIL_ID))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Glide.with(this).load(it.drinkThumb)
                    .centerCrop()
                    .placeholder(R.drawable.ic_drink_placeholder)
                    .into(drinkThumb)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
