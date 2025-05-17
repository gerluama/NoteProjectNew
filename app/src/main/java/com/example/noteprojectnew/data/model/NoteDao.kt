package com.example.noteprojectnew.data.model

import androidx.room.*
import com.example.noteprojectnew.data.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * DAO для работы с заметками в Room.
 *
 * Основные операции:
 * - Вставка, обновление, удаление
 * - Получение всех заметок (сортировка по дате или закрепленным)
 * - Поиск по заголовку/содержимому
 */
@Dao
interface NoteDao {

    // Получить все заметки (сортировка: сначала закрепленные, потом новые)
    @Query("SELECT * FROM notes ORDER BY isPinned DESC, createdAt DESC")
    fun getAllNotes(): Flow<List<Note>>

    // Получить заметку по ID
    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: Long): Note?

    // Вставить новую заметку
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note): Long

    // Обновить существующую заметку
    @Update
    suspend fun update(note: Note)

    // Удалить заметку
    @Delete
    suspend fun delete(note: Note)

    // Поиск по тексту (заголовок или содержимое)
    @Query("SELECT * FROM notes WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%'")
    fun searchNotes(query: String): Flow<List<Note>>
}