package com.granitosdearena.matiaslev.cocktails.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.granitosdearena.matiaslev.cocktails.R
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailPreviewViewModel
import com.granitosdearena.matiaslev.cocktails.presentation.cocktailPreviewRecycler.CocktailPreviewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_cocktail_preview.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class CocktailPreviewActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private val cocktailPreviewAdapter by inject<CocktailPreviewAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_preview)

        val cocktailPreviewViewModel: CocktailPreviewViewModel = get()

        disposable = cocktailPreviewViewModel.getCockailsPreview()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                cocktailPreviewRecycler.adapter = cocktailPreviewAdapter
                cocktailPreviewRecycler.layoutManager = LinearLayoutManager(this)
                cocktailPreviewAdapter.submitList(it)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
