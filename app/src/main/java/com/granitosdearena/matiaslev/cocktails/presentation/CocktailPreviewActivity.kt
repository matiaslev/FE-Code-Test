package com.granitosdearena.matiaslev.cocktails.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.granitosdearena.matiaslev.cocktails.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_cocktail_preview.*
import org.koin.android.ext.android.get

class CocktailPreviewActivity : AppCompatActivity() {

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_preview)
        val cocktailpreviewViewModel: CocktailpreviewViewModel = get()
        disposable = cocktailpreviewViewModel.getCockailsPreview().subscribe {
            textView.text = it.size.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
