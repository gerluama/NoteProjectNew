package com.example.noteprojectnew.ui.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = viewModel()
) {
    val notes by viewModel.allNotes.observeAsState(emptyList())

    NotesScreenContent(
        notes = notes,
        onNoteClick = { noteId ->
            navController.navigate("edit_note/$noteId")
        },
        onAddNote = {
            navController.navigate("edit_note/new")
        },
        onDeleteNote = { note ->
            viewModel.deleteNote(note)
        }
    )
}