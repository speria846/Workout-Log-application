package com.speriabreria.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottom_navigation:BottomNavigationView
    lateinit var plan_Fragment:FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottom_navigation=findViewById(R.id.bottom_navigation)
        plan_Fragment=findViewById(R.id.plan_flagment)
        castViews()
        setUpBottomNav()

    }
    fun castViews(){
        bottom_navigation=findViewById(R.id.bottom_navigation)
        plan_Fragment=findViewById(R.id.plan_flagment)


    }
    fun setUpBottomNav(){
        bottom_navigation.setOnItemSelectedListener { item->
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



