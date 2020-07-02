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
import tech.danielwaiguru.moviesapp.repositories.UserPrefRepository


class LoginFragment : Fragment() {
    private val userPrefRepository by lazy {
        UserPrefRepository(requireActivity())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        isUserloggedIn()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * login button on click listener
         */
        btn_login.setOnClickListener {
            if (userValidation()){
                saveUser()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, MovieFragment())
                    .commit()
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
    private fun saveUser(){
        userPrefRepository.saveUser(true)
    }
    /**
     * check if user is logged in or not
     */
    private fun isUserloggedIn(){
        if (userPrefRepository.isUserLoggedIn()){
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, MovieFragment())
                .commit()
        }
    }

}