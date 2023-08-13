package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNote : LiveData<List<Note>>
    private val repository:NoteRepository

    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNote = repository.allNotes
        // launching coroutine to use suspend function
    }
    fun deleteNode(note: Note) = CoroutineScope(Dispatchers.IO).launch {
            repository.delete(note)
    }
}