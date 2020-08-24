package tech.danielwaiguru.moviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.database.Movie
import java.util.*
import kotlin.collections.ArrayList


class MovieAdapter(private val listener: MovieItemListener):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(), Filterable{

private var movieList = emptyList<Movie>()
   var movieFilterList = emptyList<Movie>()
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

    override fun getItemCount(): Int = movieFilterList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        Picasso.get().load(movie.poster).into(holder.posterImage)
        holder.movieTitle.text = movie.title
        holder.ratingBar.rating = movie.vote_average.toFloat()
        holder.itemView.setOnClickListener {
            listener.onMovieItemClick(movie, it)
        }
    }
    internal fun setMovies(movies: List<Movie>){
        this.movieList = movies
        //this.movieFilterList = movies
        notifyDataSetChanged()
    }
    interface MovieItemListener{
        fun onMovieItemClick(movie: Movie, itemView: View)
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val searchTerm = charSequence.toString()
                movieFilterList = if (searchTerm.isEmpty()){
                    movieList
                } else{
                    val resultList = ArrayList<Movie>()
                    for (movie in movieList){
                        if (movie.title.toLowerCase(Locale.ROOT).contains(searchTerm.toLowerCase(Locale.ROOT))){
                            resultList.add(movie)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = movieFilterList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                movieFilterList = filterResults?.values as ArrayList<Movie>
                notifyDataSetChanged()
            }

        }
    }

}