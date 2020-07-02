package tech.danielwaiguru.moviesapp

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
            "A sci-fi Tv series of the first human AI child",
            R.drawable.revenge
        ),
        Movie(
            2,
            "2020-01-23",
            "Alex Rider",
            "A Tv series, Genre action, adventure, family, thriller, English language is used",
            R.drawable.alexrider
        ),
        Movie(
            3,
            "2020-01-23",
            "Crossings Sword",
            "A 2020 animation, adventure and comedy english Tv series",
            R.drawable.crossings
        ),
        Movie(
            4,
            "2020-01-23",
            "Most Dangerous Game",
            "A 2020 action and thriller Tv series season one 15 complete episodes",
            R.drawable.dangergame
        ),
        Movie(
            5,
            "2014-06-21",
            "From Dusk Till Down",
            "A 2014 action, thriller and drama Tv series recorded in english",
            R.drawable.deskdawn
        ),
        Movie(
            6,
            "2018-01-12",
            "Roswell New Mexico",
            "A 2018 Tv series recorded in mexico",
            R.drawable.roswell
        ),
        Movie(
            7,
            "2014-07-3",
            "The Search",
            "A 2014 Tv series, Genre dram and war, english language used",
            R.drawable.search
        ),
        Movie(
            8,
            "2019-11-23",
            "The Titan Game",
            "A 2019 reality-tv Tv series recorded in english",
            R.drawable.titan
        ),
        Movie(
            9,
            "2020-01-23",
            "Alex Rider",
            "A comedy Tv series season one complete",
            R.drawable.alexrider
        ),
        Movie(
            10,
            "2020-06-23",
            "Chissys Court",
            "A 2020 short and reality-tv season one tv series",
            R.drawable.court
        ),
        Movie(
            11,
            "2020-06-01",
            "Cursed",
            "A drama and fantasy Tv series season one complete season one",
            R.drawable.cursed
        ),
        Movie(
            12,
            "2020-01-23",
            "Good Behavior",
            "A drama Tv series season one complete with ten episodes",
            R.drawable.goodbehavior
        ),
        Movie(
            13,
            "2020-03-2",
            "Snow piercer",
            "A 2020 action, drama, sci-fi and thriller Tv series recorded in english",
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

}