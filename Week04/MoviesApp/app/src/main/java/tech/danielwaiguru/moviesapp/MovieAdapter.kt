package tech.danielwaiguru.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.moviesapp.data.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList = mutableListOf(
        Movie(
            1,
            "2020-02-13",
            "First Man",
            "The best movie",
            R.drawable.revenge
        ),
        Movie(
            2,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.alexrider
        ),
        Movie(
            3,
            "2020-01-23",
            "Crossings",
            "Crossings Movie",
            R.drawable.crossings
        ),
        Movie(
            4,
            "2020-01-23",
            "Alex Rider",
            "Danger Game",
            R.drawable.dangergame
        ),
        Movie(
            5,
            "2020-01-23",
            "Alex Rider",
            "Dusk Dawn",
            R.drawable.deskdawn
        ),
        Movie(
            6,
            "2020-01-23",
            "Alex Rider",
            "Roswell",
            R.drawable.roswell
        ),
        Movie(
            7,
            "2020-01-23",
            "Alex Rider",
            "Search",
            R.drawable.search
        ),
        Movie(
            8,
            "2020-01-23",
            "Titan",
            "Titan",
            R.drawable.titan
        ),
        Movie(
            9,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.alexrider
        ),
        Movie(
            10,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.court
        ),
        Movie(
            11,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.cursed
        ),
        Movie(
            12,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.goodbehavior
        ),
        Movie(
            13,
            "2020-01-23",
            "Alex Rider",
            "Alex rider Movie",
            R.drawable.snow
        )


    )
    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val posterImage: ImageView = itemView.findViewById(R.id.posterImageView)
        //val posterTitle: TextView = itemView.findViewById(R.id.posterTitle)
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
        //holder.posterTitle.text = movie.title
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            /*bundle.putString("title", movie.title)
            bundle.putString("date", movie.release_date)
            bundle.putString("summary", movie.summary)
            bundle.putInt("poster", movie.poster)*/
            //val detailsFragment = DetailsFragment()
            //detailsFragment.arguments = bundle
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

}