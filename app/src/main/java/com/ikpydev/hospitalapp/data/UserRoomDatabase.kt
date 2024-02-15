package com.ikpydev.hospitalapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1, exportSchema = false)
 abstract class UserRoomDatabase : RoomDatabase() {

   abstract fun wordDao(): Dao

   companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "word_database"
                    ).build()
                INSTANCE = instance
                instance
            }
        }
   }
}