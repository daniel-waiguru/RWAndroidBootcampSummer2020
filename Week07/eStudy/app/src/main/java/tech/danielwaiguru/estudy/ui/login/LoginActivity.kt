package tech.danielwaiguru.estudy.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import tech.danielwaiguru.estudy.MainActivity
import tech.danielwaiguru.estudy.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener { 
            initUi()
        }
    }
    private fun userDetailsValidation(): Boolean {
        var isUserValid = true
        if (etUser.text.toString().isEmpty() && etPassword.text.toString().isEmpty()){
            isUserValid = false
            Toast.makeText(this, "Username and password are required!!", Toast.LENGTH_SHORT).show()
        }

        etUser.error = if (etUser.text.toString().length < 5){
            isUserValid = false
            "Username should contain at least 5 characters"
        }
        else null
        etPassword.error = if (etPassword.text.toString().length < 5){
            isUserValid = false
            "Password should contain at least 5 characters"
        }
        else null
        return isUserValid
    }
    private fun initUi(){
        if (userDetailsValidation()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}