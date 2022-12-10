package com.davidson.compose15.data.local_ds

import androidx.room.*
import com.davidson.compose15.data.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM task_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Task>>

    @Query(
        """
        SELECT * FROM task_table ORDER BY
    CASE
        WHEN priority LIKE 'L%' THEN 1
        WHEN priority LIKE 'M%' THEN 2
        WHEN priority LIKE 'H%' THEN 3
    END
    """
    )
    fun sortByLowPriority(): Flow<List<Task>>

    @Query(
        """
        SELECT * FROM task_table ORDER BY
    CASE
        WHEN priority LIKE 'H%' THEN 1
        WHEN priority LIKE 'M%' THEN 2
        WHEN priority LIKE 'L%' THEN 3
    END
    """
    )
    fun sortByHighPriority(): Flow<List<Task>>
}