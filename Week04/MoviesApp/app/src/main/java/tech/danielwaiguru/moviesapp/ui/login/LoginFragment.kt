package tech.danielwaiguru.moviesapp.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.etPassword
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.ext.android.getKoin
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import tech.danielwaiguru.moviesapp.R
import tech.danielwaiguru.moviesapp.repositories.UserPrefRepository
import tech.danielwaiguru.moviesapp.ui.movie.MovieFragment
import tech.danielwaiguru.moviesapp.ui.register.RegisterFragment
import tech.danielwaiguru.moviesapp.utils.Status
import tech.danielwaiguru.moviesapp.viewmodels.UserViewModel
import kotlin.math.log


class LoginFragment : Fragment() {
    private val scope: Scope = getKoin().getOrCreateScope("prefs", named("userPrefs"))
    private val userPref: UserPrefRepository = scope.get()
    private val userViewModel by viewModel<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        isUserLoggedIn()
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
        subscribers()
        /**
         * login button on click listener
         */
        btn_login.setOnClickListener {
            if (userValidation()){
                saveUser()
                userLogin()
                scope.close()
            }
        }
        txt_register.setOnClickListener {
            initUi()
        }
    }
    private fun subscribers() {
        userViewModel.userStatus.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> {
                    login.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    login.visibility = View.GONE
                    Toast.makeText(context, getString(R.string.login_error), Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    login.visibility = View.GONE
                    Log.i("User", "User is ${it.data}")
                    if (it.data != null) {
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.nav_host_fragment,
                                MovieFragment()
                            )
                            .commit()
                    } else {
                        return@Observer
                    }

                }
            }

        })
    }
    private fun userLogin() {
        userViewModel.loginUser(etUser.text.toString(), etPassword.text.toString())
    }
    /**
     * Validating user inputs
     */
    private fun userValidation(): Boolean {
        var isUserValid = true
        if (etUser.text.toString().isEmpty() && etPassword.text.toString().isEmpty()){
            isUserValid = false
            Toast.makeText(context, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
        }

        etUser.error = if (etUser.text.toString().length < 5){
            isUserValid = false
            getString(R.string.username_error)
        }
        else null
        etPassword.error = if (etPassword.text.toString().length < 6){
            isUserValid = false
            getString(R.string.password_error)
        }
        else null
        return isUserValid
    }
    /**
     * function to save user to shared preferences
     */
    private fun saveUser(){
        onCheckBoxChecked(ch_remember_me)
    }
    /**
     * check if user is logged in or not
     */
    private fun isUserLoggedIn(){
        if (userPref.isUserLoggedIn()){
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.nav_host_fragment,
                    MovieFragment()
                )
                .commit()
        }
    }
    private fun initUi(){
        val registerFragment = RegisterFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, registerFragment)
            .addToBackStack(null)
            .commit()
    }
    private fun onCheckBoxChecked(view: View){
        if (view is CheckBox){
            val checked: Boolean = view.isChecked
            if (checked){
                userPref.saveUser(true)
            }
            else{
                userPref.saveUser(false)
            }
        }
    }
}