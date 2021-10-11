package com.example.usetech2.ui.superheroeslist

import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usetech2.R
import com.example.usetech2.network.Models
import com.example.usetech2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_superheroes.*
import timber.log.Timber


class SuperheroesFragment : BaseFragment<PagedList<Models.SuperHero>, SuperheroesViewModel>(),
    SearchView.OnQueryTextListener {

    override fun handleState(state: PagedList<Models.SuperHero>) {
        render(state)
    }

    private val clickListener: ClickListener = this::onPhotoClicked

    private fun onPhotoClicked(superHero: Models.SuperHero) {
        view?.let {
            findNavController(it).navigate(
                SuperheroesFragmentDirections.actionSuperheroesToBiography(
                    superHero.image.url,
                    superHero.name,
                    superHero.biography.aliases.toString(),
                    superHero.connections.relatives,
                    superHero.work.base,
                    superHero.name  // TODO ПЕРЕДЕЛАТЬ
                )
            )
        }
    }

    private val superHeroAdapter = SuperheroesPreviewAdapter(clickListener)


    override fun getLayout(): Int {
        return R.layout.fragment_superheroes
    }

    override fun onCreateCompleted() {
        initRecyclerView()
        createViewModel(SuperheroesViewModel::class.java)

    }


    private fun render(pagedPhotoList: PagedList<Models.SuperHero>) {
        superHeroAdapter.submitList(pagedPhotoList)
        Timber.d("pagedPhotoList : %s", pagedPhotoList)
    }

    private fun initRecyclerView() {
        rv_superheroes.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = superHeroAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager =
            requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.app_bar_search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
            isIconifiedByDefault = false
            queryHint = getString(R.string.search_view_hint)
            setQuery(
                if (viewModel.cachedFilter.isEmpty()) getString(R.string.search_filter_default_value) else viewModel.cachedFilter,
                true
            )
            isSubmitButtonEnabled = true
        }.setOnQueryTextListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return view?.findNavController()?.let {
            NavigationUI.onNavDestinationSelected(item, it) || super.onOptionsItemSelected(item)
        } ?: false
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let { text ->
            Timber.d("query : %s", text)
            if (text.trim().replace(" ", "").length >= 3 || text.isEmpty()) {
                viewModel.createLiveData()
                startObserving()

            }
        }
        return true
    }


}
