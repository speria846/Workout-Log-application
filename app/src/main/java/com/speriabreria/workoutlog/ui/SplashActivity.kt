package com.speriabreria.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
        var accessToken=sharedPrefs.getString("accessToken","")
        if(accessToken!!.isBlank()){
            startActivity(Intent(this,LoginActivity::class.java))

        }
        else{

        startActivity(Intent(this, HomeActivity::class.java))

    }}
}
