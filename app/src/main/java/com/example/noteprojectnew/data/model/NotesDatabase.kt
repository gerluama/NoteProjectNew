package com.example.noteprojectnew.data.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.noteproject.data.dao.NoteDao
import com.example.noteproject.data.model.Note

/**
 * База данных Room для хранения заметок.
 */
@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "notes_database"
                )
                    .fallbackToDestructiveMigration() // Удаляет старую БД при обновлении версии
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}