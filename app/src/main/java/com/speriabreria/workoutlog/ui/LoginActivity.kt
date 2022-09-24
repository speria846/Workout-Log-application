package com.speriabreria.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.speriabreria.workoutlog.ViewModel.UserViewModel
import com.speriabreria.workoutlog.databinding.ActivityLoginBinding
import com.speriabreria.workoutlog.models.LoginRequest
import com.speriabreria.workoutlog.models.LoginResponse

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        sharedPrefs = getSharedPreferences("WORKOUT_LOG_PREFS", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseliveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message, Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(this, HomeActivity::class.java))
        })
        userViewModel.errorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show()

        })
    }

    fun castView() {
        binding.btnLogin.setOnClickListener {
            validateLogin()
        }
        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }

    fun validateLogin() {
        var error = false

        binding.tiEmail.error = null
        binding.tilPasward.error = null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tiEmail.error = "Enter your email"

        }
        var password = binding.etPassward.text.toString()
        if (password.isBlank()) {
            binding.etPassward.error = "Enter your password"
        }
        if (!error) {
            var intent=Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        if (!error){
            val loginRequest = LoginRequest(email, password)
            binding.btnLogin.visibility = View.GONE
        }
    }


    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor = sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()
    }
}









