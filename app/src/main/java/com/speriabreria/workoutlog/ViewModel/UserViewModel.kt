package com.speriabreria.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.speriabreria.workoutlog.models.LoginRequest

class UserViewModel: ViewModel() {
    val UserRepository=com.speriabreria.workoutlog.Repository.UserRepository()
    val loginResponseliveData=MutableLiveData<String>()
    var errorLiveData = MutableLiveData<String>()
    fun loginUser(loginRequest: LoginRequest){
        val response=UserRepository.loginUser(loginRequest)
        if(response.isSuccessful){
            loginResponseliveData.postValue(response.body())

        }
        else {
            errorLiveData.postValue(response.errorBody()?.string())
        }
        }
    }
}