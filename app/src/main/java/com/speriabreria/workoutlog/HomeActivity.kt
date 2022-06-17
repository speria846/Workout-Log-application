package com.speriabreria.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.speriabreria.workoutlog.databinding.ActivityHomeBinding
import com.speriabreria.workoutlog.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setUpBottomNav()
    }
    fun castViews(){



    }
    fun setUpBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.plan_flagment,PlanFragment()).commit()

                    true
                }

                    R.id.track ->{
                        supportFragmentManager.beginTransaction().replace(R.id.plan_flagment,TrackFragment()).commit()
                        true
                    }
                R.id.profile ->{
                   supportFragmentManager.beginTransaction().replace(R.id.plan_flagment,ProfileFragment()).commit()
                    true
                }
                else-> false

            }


        }
    }


}



