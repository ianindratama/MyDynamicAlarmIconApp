package com.ianindratama.myalarmiconapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import java.util.Calendar

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val hour = intent?.getIntExtra(EXTRA_HOUR, -1)

        Log.d("AlarmReceiver", "Alarm triggered!")
        Log.d("AlarmReceiver", "Alarm message: $hour!")

        disabledAllActivityComponent(context)
        when(hour){
            0 -> changeIconToHour12(context)
            1 -> changeIconToHour1(context)
            2 -> changeIconToHour2(context)
            3 -> changeIconToHour3(context)
            4 -> changeIconToHour4(context)
            5 -> changeIconToHour5(context)
            6 -> changeIconToHour6(context)
            7 -> changeIconToHour7(context)
            8 -> changeIconToHour8(context)
            9 -> changeIconToHour9(context)
            10 -> changeIconToHour10(context)
            11 -> changeIconToHour11(context)
        }

        if (hour != null){
            val nextHour = if (hour == 11){
                0
            } else {
                hour.plus(1)
            }
            setChangeAppIconAlarm(context, nextHour)
        }
    }

    fun setChangeAppIconAlarm(context: Context, nextHour: Int = -1){
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val calendar = Calendar.getInstance()
        val alarmIntent = Intent(context, AlarmReceiver::class.java)

        if (nextHour == -1){
            val currentHour = calendar[Calendar.HOUR]
            alarmIntent.putExtra(EXTRA_HOUR, currentHour)
        } else {
            calendar.set(Calendar.HOUR, nextHour)
            val setNextHour = calendar[Calendar.HOUR]
            alarmIntent.putExtra(EXTRA_HOUR, setNextHour)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            TASK_ID,
            alarmIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )

        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC, calendar.timeInMillis, pendingIntent)

        Log.d("AlarmReceiver", "Alarm requested!")
    }

    private fun disabledAllActivityComponent(context: Context){

        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivity"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour1"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour2"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour3"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour4"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour5"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour6"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour7"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour8"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour9"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour10"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour11"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour12"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour1(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour1"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour2(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour2"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour3(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour3"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour4(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour4"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour5(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour5"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour6(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour6"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour7(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour7"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour8(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour8"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour9(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour9"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour10(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour10"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour11(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour11"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun changeIconToHour12(context: Context){
        val packageManager = context.packageManager
        val packageName = context.packageName

        packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                "$packageName.MainActivityHour12"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    companion object {
        const val EXTRA_HOUR = "hour"
        private const val TASK_ID = 101
    }
}