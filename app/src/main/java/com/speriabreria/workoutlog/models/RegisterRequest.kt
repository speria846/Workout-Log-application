package com.speriabreria.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name")var firtsName:String,
    @SerializedName("last_name")var lastName:String,
    @SerializedName("phone_number")var phoneNumber:String,
    var email:String,
    var password:String
)
