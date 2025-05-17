package com.example.noteprojectnew.ui.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteprojectnew.data.model.NotesDatabase
import com.example.noteprojectnew.data.model.Note
import com.example.noteprojectnew.ui.editnote.NoteRepository
import kotlinx.coroutines.launch


class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>> // Убрано прямое присваивание здесь

    init {
        val dao = NotesDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes // Присваивание в init
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    // Другие методы...


}