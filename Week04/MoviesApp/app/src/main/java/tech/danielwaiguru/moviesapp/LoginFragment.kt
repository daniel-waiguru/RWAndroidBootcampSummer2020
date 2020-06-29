package tech.danielwaiguru.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import tech.danielwaiguru.moviesapp.data.User
import tech.danielwaiguru.moviesapp.repositories.UserPrefRepository


class LoginFragment : Fragment() {
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
        /**
         * login button on click listener
         */
        btn_login.setOnClickListener {
            if (userValidation()){
                val action = LoginFragmentDirections.actionLoginFragmentToMovieFragment2()
                saverUser()
                it.findNavController().navigate(action)
            }
        }
        txt_register.setOnClickListener {
            val  action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment2()
            it.findNavController().navigate(action)
        }
    }

    /**
     * Validating user inputs
     */
    private fun userValidation(): Boolean {
        var isUserValid = true
        if (etUser.text.toString().isEmpty() && etPassword.text.toString().isEmpty()){
            isUserValid = false
            Toast.makeText(context, "Username and password are required!!", Toast.LENGTH_SHORT).show()
        }

        etUser.error = if (etUser.text.toString().length < 5){
            isUserValid = false
            "Username should contain at least 5 characters"
        }
        else null
        etPassword.error = if (etPassword.text.toString().length < 6){
            isUserValid = false
            "Password should contain at least 6 characters"
        }
        else null
        return isUserValid
    }

    /**
     * function to save user to shared preferences
     */
    private fun saverUser(){
        activity?.let {
            val user = User(true)
            val userPrefRepository = UserPrefRepository(it)
            userPrefRepository.saveUser(user)
        }
    }

}