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

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassward:TextInputLayout
    lateinit var etPassward:TextInputEditText
    lateinit var tvSignUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignUp = findViewById(R.id.tvSignUp)
        tilEmail = findViewById(R.id.tiEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassward = findViewById(R.id.tilPasward)
        etPassward = findViewById(R.id.etPassward)

        tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
    }
        fun validateLogin() {
            var error = false
            tilEmail.error = null
            tilPassward.error = null
            var email = etEmail.text.toString()
            if (email.isBlank()) {
                tilEmail.error = "Email is required"
                error = true
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                tilEmail.error="Not a valid email address"
                error=true
            }

            var password = etPassward.text.toString()
            if (password.isBlank()) {
                tilPassward.error = "Password is required"
                error = true
            }
            if(error != true) {


            }

        }
    }

