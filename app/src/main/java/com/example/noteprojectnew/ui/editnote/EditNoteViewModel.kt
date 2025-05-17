package com.example.noteprojectnew.ui.editnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.noteprojectnew.data.model.NotesDatabase
import com.example.noteprojectnew.data.model.Note
import kotlinx.coroutines.launch

class EditNoteViewModel(
    private val noteId: Long,
    application: Application
) : AndroidViewModel(application) {
    private val repository: NoteRepository

    val note = MutableLiveData<Note?>()
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    init {
        val dao = NotesDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(dao)

        if (noteId > 0) {
            viewModelScope.launch {
                note.value = repository.getNoteById(noteId)
                title.value = note.value?.title ?: ""
                content.value = note.value?.content ?: ""
            }
        }
    }

    fun saveNote() = viewModelScope.launch {
        val newNote = Note(
            id = if (noteId > 0) noteId else 0,
            title = title.value ?: "",
            content = content.value ?: ""
        )

        if (noteId > 0) {
            repository.update(newNote)
        } else {
            repository.insert(newNote)
        }
    }
}