package com.example.coffeshop.ui

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.coffeshop.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(){
    lateinit var bottomBar:BottomNavigationView
    lateinit var darkMode:Switch;
   val CAMERA_PERMISSION_CODE=1;
   val STORAGE_PERMISSION_CODE=2;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        darkMode=findViewById(R.id.darkmode)
        setCurrentFragment(FormFragment())
        darkMode.setOnCheckedChangeListener { _, isChecked ->


            if (darkMode.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            }
        }


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
                   if(checkPermission()) {

                       setCurrentFragment(CameraFragment())
                   }else{
                       Toast.makeText(this@MainActivity, "Camera Permission is required", Toast.LENGTH_SHORT).show()
                   }
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


    private fun checkPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
            false
        } else true
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.CAMERA),
            CAMERA_PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Storage Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Storage Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
       AlertDialog.Builder(this@MainActivity)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }


}