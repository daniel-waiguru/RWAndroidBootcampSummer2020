package tech.danielwaiguru.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private var isLoggedin: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_login.setOnClickListener {

        }
        txt_register.setOnClickListener {
            val  action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment2()
            it.findNavController().navigate(action)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}