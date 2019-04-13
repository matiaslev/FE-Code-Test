package com.granitosdearena.matiaslev.cocktails.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.granitosdearena.matiaslev.cocktails.R
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_cocktail.*
import org.koin.android.ext.android.get
import java.util.concurrent.TimeUnit

class CocktailActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    companion object {
        val COCKTAIL_ID = "COCKTAIL_ID"
        val COCKTAIL_NAME = "COCKTAIL_NAME"

        fun getCocktailActivityIntent(context: Context, cocktailId: String, cocktailName: String): Intent {
            return Intent(context, CocktailActivity::class.java).apply {
                putExtra(COCKTAIL_ID, cocktailId)
                putExtra(COCKTAIL_NAME, cocktailName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail)
        toolbarTittle.text = intent.getStringExtra(COCKTAIL_NAME)
        backArrow.setOnClickListener { onBackPressed() }

        val cocktailViewModel: CocktailViewModel = get()

        disposable = cocktailViewModel.getCockailById(intent.getStringExtra(COCKTAIL_ID))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Glide.with(this).load(it.drinkThumb)
                    .centerCrop()
                    .placeholder(R.drawable.ic_drink_placeholder)
                    .into(drinkThumb)


                // TODO Search a testeable and clean place for this logic
                var ingredientsWithMeasuresText = ""
                it.drinkMeasures.forEachIndexed { index, measure ->
                    ingredientsWithMeasuresText += "$measure - ${it.drinkIngredients[index]} \n"
                }

                ingredientsWithMeasures.text = ingredientsWithMeasuresText
                instructions.text = it.drinkInstructions

                progressBar.visibility = View.GONE
                drinkThumb.visibility = View.VISIBLE
                ingredientsWithMeasures.visibility = View.VISIBLE
                instructions.visibility = View.VISIBLE
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
