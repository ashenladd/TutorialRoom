package com.example.tutorialroom.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tutorialroom.data.local.dao.ContactDao
import com.example.tutorialroom.data.local.entity.Contact

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private const val DATABASE_NAME = "contact_database"

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null){
                synchronized(ContactDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            }
            return INSTANCE as ContactDatabase
        }
    }
}