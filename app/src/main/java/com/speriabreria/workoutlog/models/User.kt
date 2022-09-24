package com.speriabreria.workoutlog.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_number")val phoneNumber:String,
    @SerializedName("first_number")var firstName:String,
    @SerializedName("last_name")var lastName:String,
    @SerializedName("user_id")var userId:String,
    @SerializedName("email")var email:String
)
