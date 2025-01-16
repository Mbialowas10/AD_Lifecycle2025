package com.mbialowas.ad_lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i(TAG, "onCreate: got called here.")
    }
    override fun onStart(){
        super.onStart()
        Log.i(TAG, "onStart: got called here.")

    }
    override fun onResume(){
        super.onResume()
        Log.i(TAG, "onResume: got called here.")
    }
    override fun onPause(){
        super.onPause()
        Log.i(TAG, "onPause: got called here.")
    }
    override fun onStop(){
        super.onStop()
        Log.i(TAG, "onStop: got called here.")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i(TAG, "onDestroy: got called here.")
    }
    override fun onRestart(){
        super.onRestart()
        Log.i(TAG, "onRestart: got called here.")
    }


}