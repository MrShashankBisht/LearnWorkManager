package com.mrshashankbisht.learnworkmanager.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by Shashank on 22-04-2024
 */

class ShowNewsNotification constructor(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        return Result.success()
    }

}