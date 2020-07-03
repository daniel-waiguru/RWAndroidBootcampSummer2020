package tech.danielwaiguru.moviesapp

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
import kotlinx.android.synthetic.main.fragment_movie.view.*


class MovieFragment : Fragment() {
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieViewModel: MovieViewModel

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
        /**
         * get a reference to recyclerview
         */
        movieRecyclerView = view.movies_rv
        recyclerViewSetup()
        movieAdapter = MovieAdapter()
        movieRecyclerView.adapter = movieAdapter

        /**
         * Get an existing or new viewmodel
         */
        activity?.let {
            movieViewModel = ViewModelProvider(it).get(MovieViewModel::class.java)
            movieViewModel.allMovies.observe(it, Observer { movies->
                movies.let { movieAdapter.setMovies(movies) }
            })
        }
    }

    private fun recyclerViewSetup(){
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                movieRecyclerView.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            }
            Configuration.ORIENTATION_LANDSCAPE -> {

                movieRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)

            }

        }
    }

}