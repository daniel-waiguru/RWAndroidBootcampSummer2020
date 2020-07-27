package tech.danielwaiguru.moviesapp.ui.movie

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*
import tech.danielwaiguru.moviesapp.MovieApp
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.adapters.MovieAdapter
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.ui.details.DetailsFragment
import tech.danielwaiguru.moviesapp.viewmodels.MovieViewModel
import tech.danielwaiguru.moviesapp.viewmodels.MovieViewModelFactory


class MovieFragment : Fragment(), MovieAdapter.MovieItemListener {
    private val movieAdapter by lazy {
        MovieAdapter(this)
    }
    private val movieRepository by lazy { MovieApp.movieRepository }
    private val viewModelFactory by lazy {
        MovieViewModelFactory(movieRepository)
    }
    private val movieViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            movieViewModel.getAllMovies().observe(it, Observer { movieList ->
                movieList?.let {movies ->
                    recyclerViewSetup()
                    movies_rv.adapter = movieAdapter
                    movieAdapter.setMovies(movies)
                }
            })
        }
    }

    private fun recyclerViewSetup(){
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                movies_rv.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            }
            Configuration.ORIENTATION_LANDSCAPE -> {

                movies_rv.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)

            }

        }
    }

    override fun onMovieItemClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}