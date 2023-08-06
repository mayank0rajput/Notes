package com.example.notes

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
//    This is a Singleton to ensure that it will create only a single interface of Database
    companion object {
        private var INSTANCE: NoteDatabase? = null
        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}