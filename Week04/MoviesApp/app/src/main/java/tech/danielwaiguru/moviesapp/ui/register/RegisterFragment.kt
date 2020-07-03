package tech.danielwaiguru.moviesapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*
import tech.danielwaiguru.moviesapp.R

class RegisterFragment : Fragment() {
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
        text_login.setOnClickListener {
            val action =
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment2()
            it.findNavController().navigate(action)
        }
        btn_register.setOnClickListener {
            userDetailsValidation()
            activity?.let {

            }

        }
    }

    private fun userDetailsValidation(){
        if (usernameValidation() && passwordValidation()){
            val action =
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment2()
            findNavController().navigate(action)
        }
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
}