package com.mrshashankbisht.learnworkmanager.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.mrshashankbisht.learnworkmanager.component.ClickableTextButton
import com.mrshashankbisht.learnworkmanager.util.PERIODIC_NOTIFICATION_WORKER_NAME
import com.mrshashankbisht.learnworkmanager.worker.PushNotificationPeriodicWorkManager
import com.mrshashankbisht.learnworkmanager.worker.PushNotificationWorkManager
import java.util.concurrent.TimeUnit

/**
 * Created by Shashank on 22-04-2024
 */

@Composable
fun MainScreen() {
    val context: Context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableTextButton(text = "OneTimeWorkRequestBuilder") {
            createOnTimeWorkRequestBuilder(context)
        }
        Spacer(modifier = Modifier.height(10f.dp))
        ClickableTextButton(text = "PeriodicWorkRequestBuilder") {
            launchPeriodicWork(context)
        }
        Spacer(modifier = Modifier.height(10f.dp))
        ClickableTextButton(text = "CancelPeriodicWorkRequestBuilder") {
            cancelPeriodicWorker(PERIODIC_NOTIFICATION_WORKER_NAME, context)
        }
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

/**
 * create a one time launch worker request and submit that worker request to system
 * */
fun createOnTimeWorkRequestBuilder(context: Context) {
    // 1) create a request builder
    val pushNotificationWorkManagerRequestBuilder: WorkRequest =
        OneTimeWorkRequestBuilder<PushNotificationWorkManager>()
            .build()
    // submit the workerRequest to the system
    WorkManager
        .getInstance(context)
        .enqueue(pushNotificationWorkManagerRequestBuilder)
}


/**
 * create a one time launch worker request and submit that worker request to system
 * */
fun launchPeriodicWork(context: Context) {
    // 1) create a request builder
    val pushNotificationWorkManagerRequestBuilder: PeriodicWorkRequest =
        PeriodicWorkRequestBuilder<PushNotificationPeriodicWorkManager>(1L, TimeUnit.SECONDS,)
            .build()
    // submit the workerRequest to the system
    WorkManager
        .getInstance(context)
        .enqueueUniquePeriodicWork(PERIODIC_NOTIFICATION_WORKER_NAME, ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE, pushNotificationWorkManagerRequestBuilder)
}

fun cancelPeriodicWorker(uniqueWorkerName : String, context: Context) {
    WorkManager.getInstance(context).cancelUniqueWork(uniqueWorkerName)
}