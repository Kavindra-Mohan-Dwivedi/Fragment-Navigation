package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton=findViewById<Button>(R.id.addFragment)
        addButton.setOnClickListener {
            val fragment=OneFragment()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction =fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainfragment,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val removeButton = findViewById<Button>(R.id.removeFragment)
        removeButton.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.mainfragment)

            fragment?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }
        val replaceButton = findViewById<Button>(R.id.replaceFragment)
        replaceButton.setOnClickListener {
            val fragment = TwoFragment()
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.mainfragment,fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }

        }


    }
}