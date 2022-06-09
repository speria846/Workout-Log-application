package com.speriabreria.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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
        btnLogin=findViewById(R.id.btnLogin)
        tvSignUp=findViewById(R.id.tvSignUp)
        tilEmail=findViewById(R.id.tiEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassward=findViewById(R.id.tilPasward)
        etPassward=findViewById(R.id.etPassward)
        tvSignUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}

