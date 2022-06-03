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

class SignUpActivity : AppCompatActivity() {
    lateinit var tilName:TextInputLayout
    lateinit var etName:TextInputEditText
    lateinit var tilname2:TextInputLayout
    lateinit var etname2: TextInputEditText
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassward:TextInputLayout
    lateinit var etPassward:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    lateinit var etConfirm:TextInputEditText
    lateinit var btnsignup:Button
    lateinit var tvlogin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tilName=findViewById(R.id.tilName)
        etName=findViewById(R.id.etName)
        tilname2=findViewById(R.id.tilName2)
        etname2=findViewById(R.id.etname2)
        etEmail=findViewById(R.id.etEmail)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassward=findViewById(R.id.tilPassward)
        etPassward=findViewById(R.id.etPassward)
        tilConfirm=findViewById(R.id.tilConfirm)
        etConfirm=findViewById(R.id.etConfirm)
        btnsignup=findViewById(R.id.btnsignup)
        tvlogin=findViewById(R.id.tvlogin)
        btnsignup.setOnClickListener { validation()}
        tvlogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }


    fun validation(){
        var error = false
        tilName.error = null
        tilname2.error=null
        tilEmail.error = null
        tilConfirm.error=null
        tilPassward.error = null

        var name = etName.text.toString()
        if (name.isBlank()) {
            tilName.error = "First Name is required"
            error=true

    }
        var name2 = etname2.text.toString()
        if (name2.isBlank()) {
            tilname2.error = "Name is required"
            error=true

        }
        var email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error=true

        }
        var passward = etPassward.text.toString()
        if (passward.isBlank()) {
            tilPassward.error = "Enter the passward"
            error=true

        }
        var confirm = etConfirm.text.toString()
        if (confirm.isBlank()) {
            tilConfirm.error = "Enter the correct passward"
            error=true

        }
        if(error !=true){

        }

    }
}

