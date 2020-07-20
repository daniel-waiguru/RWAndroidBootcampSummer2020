package tech.danielwaiguru.moviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.database.Movie


class MovieAdapter(private val listener: MovieItemListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

private var movieList = emptyList<Movie>()
    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val posterImage: ImageView = itemView.findViewById(R.id.posterImageView)
        val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_view_holder,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        Picasso.get().load(movie.poster).into(holder.posterImage)
        holder.movieTitle.text = movie.title
        holder.ratingBar.rating = movie.vote_average.toFloat()
        holder.itemView.setOnClickListener {
            listener.onMovieItemClick(movie)
        }
    }
    internal fun setMovies(movies: List<Movie>){
        this.movieList = movies
        notifyDataSetChanged()
    }
    interface MovieItemListener{
        fun onMovieItemClick(movie: Movie)
    }
}