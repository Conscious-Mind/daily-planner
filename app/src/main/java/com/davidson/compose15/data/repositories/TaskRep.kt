package com.davidson.compose15.data.repositories

import com.davidson.compose15.data.local_ds.TaskDao
import com.davidson.compose15.data.models.Task
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TaskRepo @Inject constructor(private val taskDao: TaskDao) {

    val getAllTasks: Flow<List<Task>> = taskDao.getAllTasks()
    val sortByLowPriority: Flow<List<Task>> = taskDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<Task>> = taskDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<Task> {
        return taskDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(task: Task) {
        taskDao.addTask(task = task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task = task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task = task)
    }

    suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<Task>> {
        return taskDao.searchDatabase(searchQuery = searchQuery)
    }

}