package com.mrshashankbisht.learnworkmanager

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.mrshashankbisht.learnworkmanager.util.CHANNEL_ID
import dagger.hilt.android.HiltAndroidApp


/**
 * Created by Shashank on 22-04-2024
 */
@HiltAndroidApp
class Application: Application() {
    override fun onCreate() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel.
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            mChannel.lightColor = Color.Red.toArgb()
            // adding sound to notification channel

            // Define the sound URI
            val soundUri =
                Uri.parse("android.resource://" + packageName + "/" + R.raw.notification_sound)
            // Create the audio attributes for the notification
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()
            mChannel.setSound(soundUri, audioAttributes)

            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        super.onCreate()
    }
}