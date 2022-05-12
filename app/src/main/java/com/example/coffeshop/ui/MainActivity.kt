package com.example.coffeshop.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.coffeshop.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){
    lateinit var bottomBar:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(FormFragment())
        bottomBar=findViewById(R.id.bottomNavigationView)

           bottomBar.setOnItemSelectedListener { item ->
               if(item.itemId==R.id.form)
               {

                   setCurrentFragment(FormFragment())
                  // return  true;
               }

               if(item.itemId==R.id.coffeeItems)
               {

                   setCurrentFragment(CoffeItems())
                  // return  true;
               }

               if(item.itemId==R.id.about)
               {

                   setCurrentFragment(AboutFragment())
                  // return  true;
               }


               if(item.itemId==R.id.camera)
               {

                   setCurrentFragment(CameraFragment())
                  // return  true;
               }


             true;
           }


    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }


}