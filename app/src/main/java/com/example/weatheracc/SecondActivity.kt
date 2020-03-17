package com.example.weatheracc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (intent.action == "Calculate") {
            val resultIntent = Intent().apply {
                putExtra("result", calculate(intent.getIntExtra("Number", 0)))
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun calculate(value: Int): Boolean {
        return value % 2 == 0
    }
}
