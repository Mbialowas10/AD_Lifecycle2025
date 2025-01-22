package com.mbialowas.ad_lifecycle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
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

        // register our control
        val btnLinear = findViewById<Button>(R.id.btn_linear)
        val btnVertical = findViewById<Button>(R.id.btn_vertical)
        val btnRelative = findViewById<Button>(R.id.btn_relative)
        val btnConstraint = findViewById<Button>(R.id.btn_constraint)
        val btnSpec = findViewById<Button>(R.id.btn_spec)

        // event handlers
        btnLinear.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            startActivity(intent)
        }
        btnVertical.setOnClickListener {
            Toast.makeText(this, "Main Activity is already using a vertical layout.", Toast.LENGTH_SHORT).show()
        }
        btnRelative.setOnClickListener{
            val intent = Intent(this,RelativeActivity::class.java)
            startActivity(intent)
        }
        btnConstraint.setOnClickListener{
            val intent = Intent(this,ConstraintActivity::class.java)
            startActivity(intent)
        }
//        btnSpec.setOnClickListener{
//            val intent = Intent(this,ConstraintActivity::class.java)
//            startActivity(intent)
//        }

        btnSpec.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW).apply{
                data = Uri.parse("https://cnn.com")
            }
            startActivity(intent)
        }

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