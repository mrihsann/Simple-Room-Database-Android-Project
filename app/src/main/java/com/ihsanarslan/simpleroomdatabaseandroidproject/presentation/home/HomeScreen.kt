package com.ihsanarslan.simpleroomdatabaseandroidproject.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteEntity

@Composable
fun HomeScreen(){

    val viewModel : HomeViewModel = viewModel()

    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column {
        TextField(
            value = title.value,
            onValueChange = { title.value = it }
        )
        TextField(
            value = description.value,
            onValueChange = { description.value = it }
        )
        Button(
            onClick = {
                val noteEntity = NoteEntity(
                    title = title.value,
                    description = description.value
                )
                viewModel.insert(noteEntity = noteEntity)
            }
        ) {
            Text("Notu kaydet")
        }
    }
}