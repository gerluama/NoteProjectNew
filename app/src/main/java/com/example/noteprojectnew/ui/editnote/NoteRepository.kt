package com.example.noteprojectnew.ui.editnote

import com.example.noteprojectnew.data.model.Note
import com.example.noteprojectnew.data.model.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    // Получение всех заметок
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    // Получение конкретной заметки по ID
    suspend fun getNoteById(id: Long): Note? {
        return noteDao.getNoteById(id)
    }

    // Добавление новой заметки
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    // Обновление существующей заметки
    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    // Удаление заметки
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}