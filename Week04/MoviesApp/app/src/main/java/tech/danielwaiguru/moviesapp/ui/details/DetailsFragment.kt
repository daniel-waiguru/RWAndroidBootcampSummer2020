package tech.danielwaiguru.moviesapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_details.*

import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.adapters.MovieAdapter
import tech.danielwaiguru.moviesapp.database.Movie


class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            val movie: Movie? = it.getParcelable("movie")
            poster.setImageResource(movie!!.poster)
            movie_title.text = movie.title
            release_date.text = movie.release_date
            movie_description.text = movie.summary
        }
    }
}