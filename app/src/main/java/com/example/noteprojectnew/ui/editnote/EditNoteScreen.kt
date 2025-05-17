package com.example.noteprojectnew.ui.editnote

import androidx.compose.runtime.Composable
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalUriHandler
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditNoteScreen(
    noteId: Long,
    navController: NavController,
    viewModel: EditNoteViewModel = viewModel(
        factory = EditNoteViewModelFactory(noteId)
    )
) {
    val title by viewModel.title.observeAsState("")
    val content by viewModel.content.observeAsState("")

    EditNoteScreenContent(
        title = title,
        content = content,
        onTitleChange = { viewModel.title.value = it },
        onContentChange = { viewModel.content.value = it },
        onSave = {
            viewModel.saveNote()
            navController.popBackStack()
        },
        onBack = { navController.popBackStack() }
    )
}

class EditNoteViewModelFactory(
    private val noteId: Long
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            return EditNoteViewModel(noteId, Application()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}