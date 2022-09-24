package com.speriabreria.workoutlog.api

import com.speriabreria.workoutlog.models.LoginRequest
import com.speriabreria.workoutlog.models.LoginResponse
import com.speriabreria.workoutlog.models.RegisterRequest
import com.speriabreria.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun RegisterUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

}