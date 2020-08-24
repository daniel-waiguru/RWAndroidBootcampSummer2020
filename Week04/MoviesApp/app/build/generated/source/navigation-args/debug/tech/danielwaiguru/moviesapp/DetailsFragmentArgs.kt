package tech.danielwaiguru.moviesapp

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

data class DetailsFragmentArgs(
  val title: String,
  val date: String,
  val desc: String,
  val poster: Int
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("title", this.title)
    result.putString("date", this.date)
    result.putString("desc", this.desc)
    result.putInt("poster", this.poster)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): DetailsFragmentArgs {
      bundle.setClassLoader(DetailsFragmentArgs::class.java.classLoader)
      val __title : String?
      if (bundle.containsKey("title")) {
        __title = bundle.getString("title")
        if (__title == null) {
          throw IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue")
      }
      val __date : String?
      if (bundle.containsKey("date")) {
        __date = bundle.getString("date")
        if (__date == null) {
          throw IllegalArgumentException("Argument \"date\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"date\" is missing and does not have an android:defaultValue")
      }
      val __desc : String?
      if (bundle.containsKey("desc")) {
        __desc = bundle.getString("desc")
        if (__desc == null) {
          throw IllegalArgumentException("Argument \"desc\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"desc\" is missing and does not have an android:defaultValue")
      }
      val __poster : Int
      if (bundle.containsKey("poster")) {
        __poster = bundle.getInt("poster")
      } else {
        throw IllegalArgumentException("Required argument \"poster\" is missing and does not have an android:defaultValue")
      }
      return DetailsFragmentArgs(__title, __date, __desc, __poster)
    }
  }
}
