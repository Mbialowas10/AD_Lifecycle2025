package com.mbialowas.ad_lifecycle

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val CALL_PHONE_REQUEST_CODE = 1
    private val TAG = "MainActivity"

    private val calledNumbers = mutableListOf<String>() // list tracking all phone numbers

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

        initializeViews()

    }

    private fun initializeViews() {
        // register our controls
        val btn_phone = findViewById<Button>(R.id.btn_phone)
        val btn_call_log = findViewById<Button>(R.id.btn_call_log)
        val btn_photo = findViewById<Button>(R.id.btn_photo)
        val btn_camera = findViewById<Button>(R.id.btn_camera)
        val btn_alarm = findViewById<Button>(R.id.btn_alarm)

        val phone_number:String = "+1234567890"

        btn_phone.setOnClickListener{ makeACall(phone_number) }

        btn_call_log.setOnClickListener{
            val intent = Intent(this,CallLogActivity::class.java)
            intent.putStringArrayListExtra("calledNumbers", ArrayList(calledNumbers))
            startActivity(intent)
        }

        btn_photo.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://media/internal/images/media")
            startActivity(intent)
        }
        btn_camera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        btn_alarm.setOnClickListener{
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }



    }
    private fun makeACall(phone_number:String) {
        calledNumbers.add("+14319997878")
        calledNumbers.add("+14319997970")
        calledNumbers.add("+14319997971")
        calledNumbers.add("+12042222222")
        calledNumbers.add("+12042222223")
        calledNumbers.add(phone_number)

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED) {
            // permission is granted, proceed to make phone call
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phone_number")
            }
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                CALL_PHONE_REQUEST_CODE
            )
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