package com.speriabreria.workoutlog.Repository

import com.speriabreria.workoutlog.api.ApiClient
import com.speriabreria.workoutlog.api.ApiInterface
import com.speriabreria.workoutlog.models.LoginRequest
import com.speriabreria.workoutlog.models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
    = withContext(Dispatchers.IO){
        val response=apiClient.loginUser(loginRequest)
        return@withContext response
    }

}