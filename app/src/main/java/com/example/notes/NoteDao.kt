package com.example.notes
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
    suspend fun insert(note: Note)
    @Delete
    suspend fun delete(note: Note)
//    We need to know recent updates in the data that we get in following function
//    So we will use the LiveData Component of Architecture
    @Query("Select * from notes_table order by id ASC")
    suspend fun getAllNotes(): LiveData<List<Note>>
}