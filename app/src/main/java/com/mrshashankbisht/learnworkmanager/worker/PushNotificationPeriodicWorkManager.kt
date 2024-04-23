package com.mrshashankbisht.learnworkmanager.worker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.mrshashankbisht.learnworkmanager.R
import com.mrshashankbisht.learnworkmanager.util.CHANNEL_ID
import com.mrshashankbisht.learnworkmanager.util.ONE_TIME_WORK_NOTIFICATION_ID
import kotlinx.coroutines.delay


/**
 * Created by Shashank on 22-04-2024
 */
/**
 * What is the work of this class ?
 * so this class will show notification in every 10 seconds interval
 * and even you will close your application and remove your application from the recent tab
 * even then this will continue update the notification counter */
class PushNotificationPeriodicWorkManager constructor(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
        showNotification(applicationContext, builder)
        return Result.success()
    }

    private fun showNotification(context: Context, builder: NotificationCompat.Builder) {
        builder.setContentTitle("Notification Count ")
        builder.setContentText("This is a simple OneTimeWorkManager...")
        builder.setStyle(NotificationCompat.BigTextStyle().bigText("This is a simple OneTimeWorkManager that shows the simple notification "))
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        NotificationManagerCompat.from(context).notify(ONE_TIME_WORK_NOTIFICATION_ID, builder.build())
    }
}