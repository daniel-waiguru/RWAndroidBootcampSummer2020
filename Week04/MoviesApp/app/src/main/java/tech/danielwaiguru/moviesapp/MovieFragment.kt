package tech.danielwaiguru.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.view.*


class MovieFragment : Fragment() {
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        movieRecyclerView.layoutManager = GridLayoutManager(context, 3)
        movieAdapter = MovieAdapter()
        movieRecyclerView.adapter = movieAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment()
    }
}