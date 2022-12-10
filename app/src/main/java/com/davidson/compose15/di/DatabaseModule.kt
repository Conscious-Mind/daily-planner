package com.davidson.compose15.di

import android.content.Context
import androidx.room.Room
import com.davidson.compose15.data.local_ds.TaskDatabase
import com.davidson.compose15.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TaskDatabase::class.java,
        DATABASE_NAME
    ).createFromAsset("database/populate.db").build()

    @Singleton
    @Provides
    fun provideDao(database: TaskDatabase) = database.taskDao()

}