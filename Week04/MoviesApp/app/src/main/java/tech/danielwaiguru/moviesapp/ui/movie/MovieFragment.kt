package tech.danielwaiguru.moviesapp.ui.movie

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.adapters.MovieAdapter
import tech.danielwaiguru.moviesapp.database.Movie
import tech.danielwaiguru.moviesapp.ui.details.DetailsFragment
import tech.danielwaiguru.moviesapp.viewmodels.MovieViewModel


class MovieFragment : Fragment(), MovieAdapter.MovieItemListener {
    private val movieAdapter by lazy {
        MovieAdapter(this)
    }
    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
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
        movieViewModel.allMovies.observe(viewLifecycleOwner, Observer { movieList ->
            movieList?.let {
                recyclerViewSetup()
                movieAdapter.setMovies(it)
                movies_rv.adapter = movieAdapter
            }
        })
    }

    private fun recyclerViewSetup(){
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                movies_rv.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            }
            Configuration.ORIENTATION_LANDSCAPE -> {

                movies_rv.layoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)

            }

        }
    }
    private fun onMovieItemClicked(movie: Movie){

        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, detailsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onMovieItemClick(movie: Movie) {
        Toast.makeText(requireContext(), "Movie ${movie.title} clicked", Toast.LENGTH_SHORT).show()
    }
}