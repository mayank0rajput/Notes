package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNote : LiveData<List<Note>>

    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNote = repository.allNotes
        // launching coroutine to use suspend function
        fun insert(note: Note) = viewModelFactory {  }
    }
}