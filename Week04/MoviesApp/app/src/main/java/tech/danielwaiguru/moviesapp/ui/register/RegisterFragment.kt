package tech.danielwaiguru.moviesapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_register.*
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.ui.login.LoginFragment
import tech.danielwaiguru.moviesapp.viewmodels.UserViewModel

class RegisterFragment : Fragment() {
    /*private val userViewModel by lazy {
        ViewModelProvider(this).get(UserViewModel::class.java)
    }*/
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            userViewModel = ViewModelProvider(it).get(UserViewModel::class.java)
        }
        text_login.setOnClickListener {
            initUi()
        }
        btn_register.setOnClickListener {
            initLoginUi()
        }
    }

    private fun userDetailsValidation(): Boolean {
       return usernameValidation() && passwordValidation()
    }
    private fun usernameValidation(): Boolean {

        var isUsernameValid = true
        etUsername.error = when {
            etUsername.text.toString().isEmpty() -> {
                isUsernameValid = false
                "Username is required"
            }
            etUsername.text.toString().length < 5 -> {
                isUsernameValid = false
                "Username should be at least 5 chacters long"
            }
            else -> null
        }
        return isUsernameValid
    }
    private  fun passwordValidation(): Boolean {
        var isPasswordValid = true
        etPassword.error = if (etPassword.text.toString().length < 5){
            isPasswordValid = false
            "Password should at least 5 characters"
        }
        else null
        etCPassword.error = if (etCPassword.text.toString() != etPassword.text.toString()){
            isPasswordValid = false
            "Password do not match"
        }
        else null
        return isPasswordValid
    }
    private fun initUi(){
        val loginFragment = LoginFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, loginFragment)
            .commit()
    }
    private fun registerUser(){
        if (userDetailsValidation()){
            val name = etName.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val user = User(name = name, username = username, password = password)
            userViewModel.registerUser(user)
        }
    }
    private fun initLoginUi(){
        registerUser()
        Toast.makeText(activity, "Registered successfully", Toast.LENGTH_SHORT).show()
        val loginFragment = LoginFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, loginFragment)
            .commit()
    }
}