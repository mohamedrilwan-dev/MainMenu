package com.example.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1: Button = findViewById(R.id.fragment1)
        val fragment2: Button = findViewById(R.id.fragment2)


        fragment1.setOnClickListener(View.OnClickListener {
            launchLocalApp("com.example.calculator","com.example.calculator.MainActivity" )
        })

        fragment2.setOnClickListener(View.OnClickListener {
            launchLocalApp("com.example.foodMenu","com.example.foodMenu.MainActivity" )
        })

    }

    private fun launchLocalApp(packageName: String, activityName: String) {
        try {
            val intent = Intent().apply {
                setClassName(packageName, activityName)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}
