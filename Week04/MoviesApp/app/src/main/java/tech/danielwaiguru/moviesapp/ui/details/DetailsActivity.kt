package tech.danielwaiguru.moviesapp.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.database.Movie

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val movie = intent.getParcelableExtra<Movie>(getString(R.string.movie_extra))
        movie?.let {
            Picasso.get().load(movie.poster).into(poster)
            movie_title.text = movie.title
            release_date.text = movie.release_date
            movie_description.text = movie.overview
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }
}