package tech.danielwaiguru.moviesapp

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

class MovieFragmentDirections private constructor() {
  private data class ActionMovieFragmentToDetailsFragment(
    val title: String,
    val date: String,
    val desc: String,
    val poster: Int
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_movieFragment_to_detailsFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("title", this.title)
      result.putString("date", this.date)
      result.putString("desc", this.desc)
      result.putInt("poster", this.poster)
      return result
    }
  }

  companion object {
    fun actionMovieFragmentToDetailsFragment(
      title: String,
      date: String,
      desc: String,
      poster: Int
    ): NavDirections = ActionMovieFragmentToDetailsFragment(title, date, desc, poster)
  }
}
