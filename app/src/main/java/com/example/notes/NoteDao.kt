package com.example.notes
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
//    We need to run these functions on background so that our App doesn't becomes laggy
//    We will use suspend keyword in Kotlin to apply Coroutines.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note) : Long{
    Log.d("mayank","Inserted")
        return 1L
    }
    @Delete
    suspend fun delete(note: Note) : Long {
        return 1L
    }
//    We need to know recent updates in the data that we get in following function
//    So we will use the LiveData Component of Architecture
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}