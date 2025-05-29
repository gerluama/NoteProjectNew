package com.example.noteprojectnew.ui.notes

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class NotesViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> = _notes

    private val _showDialog = mutableStateOf(false)
    val showDialog: Boolean get() = _showDialog.value

    private val _currentNote = mutableStateOf<Note?>(null)
    val currentNote: Note? get() = _currentNote.value

    fun showAddDialog() {
        _currentNote.value = null
        _showDialog.value = true
    }

    fun showEditDialog(note: Note) {
        _currentNote.value = note
        _showDialog.value = true
    }

    fun hideDialog() {
        _showDialog.value = false
    }

    fun addOrUpdateNote(title: String, content: String) {
        viewModelScope.launch {
            if (_currentNote.value == null) {
                // Добавляем новую заметку
                _notes.add(Note(
                    id = if (_notes.isEmpty()) 1 else _notes.maxOf { it.id } + 1,
                    title = title,
                    content = content
                ))
            } else {
                // Обновляем существующую заметку
                val index = _notes.indexOfFirst { it.id == _currentNote.value?.id }
                if (index != -1) {
                    _notes[index] = _notes[index].copy(
                        title = title,
                        content = content
                    )
                }
            }
            hideDialog()
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            _notes.remove(note)
        }
    }
}