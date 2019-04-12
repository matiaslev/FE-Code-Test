package com.granitosdearena.matiaslev.cocktails.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.granitosdearena.matiaslev.cocktails.R
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
                // TODO: Draw view
                Log.d("sarasa", it.drinkName)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
