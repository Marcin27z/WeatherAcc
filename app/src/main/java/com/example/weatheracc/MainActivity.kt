package com.example.weatheracc

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity2.*

class MainActivity : AppCompatActivity() {

    private val ACTION_FOO = "com.example.weatheracc.action.FOO"
    private val EXTRA_PARAM1 = "com.example.weatheracc.extra.PARAM1"
    private val SECOND_ACTIVITY_RESULT = 10
    private val receiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)
        startActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("Number", numberEditText.text.toString().toInt())
                action = "Calculate"
            }
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT)
        }
        startServiceButton.setOnClickListener {
            val serviceIntent = Intent(this, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, messageEditText.text.toString())
            }
            startService(serviceIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter("SEND_MESSAGE"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SECOND_ACTIVITY_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, data?.getBooleanExtra("result", false).toString(), Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

}
