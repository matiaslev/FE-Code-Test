package com.granitosdearena.matiaslev.cocktails.presentation.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.granitosdearena.matiaslev.cocktails.R
import com.granitosdearena.matiaslev.cocktails.presentation.viewModels.CocktailPreviewViewModel
import com.granitosdearena.matiaslev.cocktails.presentation.cocktailPreviewRecycler.CocktailPreviewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_cocktail_preview.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class CocktailPreviewActivity : AppCompatActivity() {

    private var disposables = CompositeDisposable()
    private val cocktailPreviewAdapter by inject<CocktailPreviewAdapter>()
    private val cocktailPreviewViewModel by inject<CocktailPreviewViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_preview)
        supportActionBar?.title = "Drinks By Mati Lev"

        getAllCocktailsPreview()

        search.addTextChangedListener {
            it?.let {
                if (it.isEmpty()) {
                    getAllCocktailsPreview()
                } else {
                    searchCocktailsPreviewByName(it.toString())
                }
            }
        }

        search.setOnKeyListener { view, keyCode, event ->
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    private fun searchCocktailsPreviewByName(name: String) {
        val disposable = cocktailPreviewViewModel.searchCocktailsPreviewByName(name)
            .subscribe {
                cocktailPreviewRecycler.adapter = cocktailPreviewAdapter
                cocktailPreviewRecycler.layoutManager = LinearLayoutManager(this)
                cocktailPreviewAdapter.submitList(it)
            }
        disposables.add(disposable)
    }

    private fun getAllCocktailsPreview() {
        val disposable = cocktailPreviewViewModel.getCockailsPreview()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                cocktailPreviewRecycler.adapter = cocktailPreviewAdapter
                cocktailPreviewRecycler.layoutManager = LinearLayoutManager(this)
                cocktailPreviewAdapter.submitList(it)
            }
        disposables.add(disposable)
    }

    private fun searchByName() {

    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
