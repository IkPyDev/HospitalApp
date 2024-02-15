package com.ikpydev.hospitalapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {

    @Query("SELECT * FROM USERS")
    fun selectAll(): Flow<MutableList<Users>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAdd(users: Users)
}