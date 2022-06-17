package com.speriabreria.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.speriabreria.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
    }
        fun validateLogin() {
            var error = false
            binding.tiEmail.error = null
            binding.tilPasward.error = null
            var email = binding.etEmail.text.toString()
            if (email.isBlank()) {
                binding.tiEmail.error = "Email is required"
                error = true
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.tiEmail.error="Not a valid email address"
                error=true
            }

            var password = binding.tilPasward.toString()
            if (password.isBlank()) {
                binding.tilPasward.error = "Password is required"
                error = true
            }
            if(error != true) {


            }

        }
    }

