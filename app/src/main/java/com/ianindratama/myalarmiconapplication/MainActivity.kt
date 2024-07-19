package com.ianindratama.myalarmiconapplication

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ianindratama.myalarmiconapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { this@MainActivity.changeIcon() }) {
                        Text(text = "Buy Pro version")
                    }
                }
            }
        }

        alarmReceiver = AlarmReceiver()
    }

    override fun onStop() {
        super.onStop()
        alarmReceiver.setChangeAppIconAlarm(this)
    }
}

fun Activity.changeIcon() {
    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            "$packageName.MainActivity"
        ),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )

    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            "$packageName.MainActivityPro"
        ),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
}