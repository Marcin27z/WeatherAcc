package com.example.weatheracc

import android.app.IntentService
import android.content.Intent

// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.weatheracc.action.FOO"

private const val EXTRA_PARAM1 = "com.example.weatheracc.extra.PARAM1"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                handleMessage(param1)
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleMessage(message: String) {
        val intent = Intent().apply {
            action = "SEND_MESSAGE"
            putExtra("message", message)
        }
        sendBroadcast(intent)
    }

}
