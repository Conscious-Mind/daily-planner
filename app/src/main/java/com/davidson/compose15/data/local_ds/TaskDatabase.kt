package com.davidson.compose15.data.local_ds

import androidx.room.Database
import androidx.room.RoomDatabase
import com.davidson.compose15.data.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao


}