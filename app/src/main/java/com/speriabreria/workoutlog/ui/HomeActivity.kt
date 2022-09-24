package com.speriabreria.workoutlog.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.speriabreria.workoutlog.R
import com.speriabreria.workoutlog.databinding.ActivityHomeBinding
import com.speriabreria.workoutlog.models.LoginResponse

class HomeActivity : AppCompatActivity(){
    lateinit var binding:ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNav()
        binding.tvLogout.setOnClickListener{
            sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
            val editor=sharedPrefs.edit()
                editor.putString( "accessToken","")
                editor.putString("userId","")
                editor.putString("profileId","")
                editor.apply()

        }


    }

    fun setUpBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){R.id.plan ->{supportFragmentManager.beginTransaction().replace(
                        R.id.plan_flagment, PlanFragment()).commit()
                    true
                }
                    R.id.track ->{
                        supportFragmentManager.beginTransaction().replace(
                            R.id.plan_flagment,
                            TrackFragment()
                        ).commit()
                        true
                    }
                R.id.profile ->{
                   supportFragmentManager.beginTransaction().replace(
                       R.id.plan_flagment,
                       ProfileFragment()
                   ).commit()
                    true
                }
                else-> false

            }
        }
    }

}



