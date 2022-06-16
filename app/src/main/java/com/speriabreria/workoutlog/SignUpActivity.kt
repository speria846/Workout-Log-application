package com.speriabreria.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tilName:TextInputLayout
    lateinit var etName:TextInputEditText
    lateinit var tilName2:TextInputLayout
    lateinit var etname2: TextInputEditText
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassward:TextInputLayout
    lateinit var etPassward:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    lateinit var etConfirm:TextInputEditText
    lateinit var btnsignup:Button
    lateinit var tvLogin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        tilName=findViewById(R.id.tilName)
        etName=findViewById(R.id.etName)
        tilName2=findViewById(R.id.tilName2)
        etname2=findViewById(R.id.etname2)
        etEmail=findViewById(R.id.etEmail)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassward=findViewById(R.id.tilPassward)
        etPassward=findViewById(R.id.etPassward)
        tilConfirm=findViewById(R.id.tilConfirm)
        etConfirm=findViewById(R.id.etConfirm)
        btnsignup=findViewById(R.id.btnSignup)
        tvLogin=findViewById(R.id.tvLogin)
        btnsignup.setOnClickListener { validation()}
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
//        btnsignup.setOnClickListener {
//            val intent=Intent(this,HomeActivity::class.java)
//            startActivity(intent                                 )
//        }

    }
    fun validation() {
        var error = false
        tilName.error = null
        tilName2.error = null
        tilEmail.error = null
        tilConfirm.error = null
        tilPassward.error = null

        val name = etName.text.toString()
        if (name.isBlank()) {
            tilName.error = "First Name is required"
            error = true

        }
        val name2 = etname2.text.toString()
        if (name2.isBlank()) {
            tilName2.error = "Name is required"
            error = true

        }
        val email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error = true

        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
         tilEmail.error="Not a valid email address"
            error=true
        }

        val passward = etPassward.text.toString()
        if (passward.isBlank()) {
            tilPassward.error = "Enter the passward"
            error=true


        }
        val confirm = etConfirm.text.toString()
        if (confirm.isBlank()) {
            tilConfirm.error = "Enter the correct passward"
            error=true
        }
            if (passward!=confirm){
                tilConfirm.error="doesnot match"
                error=true
            }



        if (error == true){

    }
}}

