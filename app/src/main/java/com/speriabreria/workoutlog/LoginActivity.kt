package com.speriabreria.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassward:TextInputLayout
    lateinit var etPassward:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            var intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tiEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassward=findViewById(R.id.tilPasward)
        etPassward=findViewById(R.id.etPassward)
        btnLogin.setOnClickListener { validateLogin() }

    }
    fun validateLogin() {
        var error = false
        tilEmail.error = null
        tilPassward.error = null
        var email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "email is required"
            error=true

        }

        var passward = etPassward.text.toString()
        if (passward.isBlank()) {
            tilPassward.error ="passward is required"
            error=true

        }
    }
}