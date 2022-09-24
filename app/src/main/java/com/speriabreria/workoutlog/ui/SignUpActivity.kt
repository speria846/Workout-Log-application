package com.speriabreria.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.speriabreria.workoutlog.api.ApiClient
import com.speriabreria.workoutlog.api.ApiInterface
import com.speriabreria.workoutlog.databinding.ActivitySignUpBinding
import com.speriabreria.workoutlog.models.RegisterRequest
import com.speriabreria.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignup.setOnClickListener { validation()}
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
    fun validation() {
        var error = false
        binding.tilName.error = null
        binding.tilName2.error = null
        binding.tilEmail.error = null
        binding.tilConfirm.error = null
        binding.tilPassward.error = null

        val name = binding.etName.text.toString()
        if (name.isBlank()) {
            binding.tilName.error = "First Name is required"


        }
        val name2 = binding.etname2.text.toString()
        if (name2.isBlank()) {
            binding.tilName2.error = "Name is required"


        }
        val email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"


        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
         binding.tilEmail.error="Not a valid email address"

        }

        val passward = binding.etPassward.text.toString()
        if (passward.isBlank()) {
            binding.tilPassward.error = "Enter the password"
            error=true

            val phone = binding.etnumber.toString()
            if (phone.isBlank()) {
                binding.tilnumber.error = "Enter the password"



        }
        val confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Enter the correct password"
        }
            if (passward!=confirm){
                binding.tilConfirm.error="doesn't match"
                error=true
            }
        if (!error){

        }
        if (error == true) {
            val registerRequest=RegisterRequest(name, name2, email, passward,phone)
            (registerRequest)
            startActivity(Intent(baseContext, LoginActivity::class.java))
        }
         }
        fun makeRegisterRequest(registerRequest: RegisterRequest){
            val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
            val request=apiClient.RegisterUser(registerRequest)

            request.enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    }

                }
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                 Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }

            })
        }
}


}

