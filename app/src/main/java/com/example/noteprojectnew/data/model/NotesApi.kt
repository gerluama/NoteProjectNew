package com.example.noteprojectnew.data.model

import com.example.noteprojectnew.data.model.Note
import retrofit2.http.*

/**
 * API для работы с заметками на сервере.
 */
interface NotesApi {

    @GET("notes")
    suspend fun getAllNotes(): List<Note>

    @GET("notes/{id}")
    suspend fun getNoteById(@Path("id") noteId: Long): Note

    @POST("notes")
    suspend fun createNote(@Body note: Note): Note

    @PUT("notes/{id}")
    suspend fun updateNote(@Path("id") noteId: Long, @Body note: Note): Note

    @DELETE("notes/{id}")
    suspend fun deleteNote(@Path("id") noteId: Long)
}