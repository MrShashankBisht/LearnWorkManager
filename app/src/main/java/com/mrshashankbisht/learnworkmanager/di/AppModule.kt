package com.mrshashankbisht.learnworkmanager.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Shashank on 22-04-2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun getApplicationContext(@ApplicationContext applicationContext: ApplicationContext): ApplicationContext

    @Singleton
    @Binds
    abstract fun getContext(context: Context): Context
}