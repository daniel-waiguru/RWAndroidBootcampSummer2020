package tech.danielwaiguru.moviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.moviesapp.database.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

private var movieList = emptyList<Movie>()
    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val posterImage: ImageView = itemView.findViewById(R.id.posterImageView)

        fun bind(movie: Movie){
            posterImage.setImageResource(movie.poster)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item_view_holder, parent, false
        )
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.posterImage.setImageResource(movie.poster)
        holder.itemView.setOnClickListener {

            val action = MovieFragmentDirections.actionMovieFragmentToDetailsFragment(
                movie.title,
                movie.release_date,
                movie.summary,
                movie.poster
            )
            it.findNavController().navigate(action)
        }
        holder.bind(movie)
    }
    internal fun setMovies(movies: List<Movie>){
        this.movieList = movies
        notifyDataSetChanged()
    }

}