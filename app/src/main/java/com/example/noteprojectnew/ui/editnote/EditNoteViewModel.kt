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
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    init {
        val dao = NotesDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(dao)

        if (noteId > 0) {
            loadNote()
        }
    }

    private fun loadNote() = viewModelScope.launch {
        val note = repository.getNoteById(noteId)
        note?.let {
            title.postValue(it.title)
            content.postValue(it.content)
        }
    }

    fun saveNote() = viewModelScope.launch {
        val currentTitle = title.value ?: ""
        val currentContent = content.value ?: ""

        val note = Note(
            id = if (noteId > 0) noteId else 0,
            title = currentTitle,
            content = currentContent
        )

        if (noteId > 0) {
            repository.update(note)
        } else {
            repository.insert(note)
        }
    }
}