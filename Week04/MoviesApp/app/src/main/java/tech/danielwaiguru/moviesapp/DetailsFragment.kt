package tech.danielwaiguru.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_details.*
import tech.danielwaiguru.moviesapp.data.Movie


class DetailsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
            val bundle = DetailsFragmentArgs.fromBundle(it)
            poster.setImageResource(it.getInt("poster"))
            movie_title.text = bundle.title
            release_date.text = bundle.date
            movie_description.text = bundle.desc
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}