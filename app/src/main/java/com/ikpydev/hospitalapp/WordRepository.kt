package com.ikpydev.hospitalapp

import androidx.annotation.WorkerThread
import com.ikpydev.hospitalapp.data.Dao
import com.ikpydev.hospitalapp.data.Users
import kotlinx.coroutines.flow.Flow

class WordRepository(private val dao: Dao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<MutableList<Users>> = dao.selectAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(users: Users) {
        dao.insertAdd(users)
    }
}