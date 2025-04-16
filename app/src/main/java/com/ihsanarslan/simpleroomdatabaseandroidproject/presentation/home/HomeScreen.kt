package com.ihsanarslan.simpleroomdatabaseandroidproject.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteEntity

@Composable
fun HomeScreen(){

    val viewModel : HomeViewModel = viewModel()
    val notes = viewModel.notes.observeAsState(emptyList())

    val id = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column {
        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            value = id.value,
            onValueChange = { id.value = it }
        )
        TextField(
            value = title.value,
            onValueChange = { title.value = it }
        )
        TextField(
            value = description.value,
            onValueChange = { description.value = it }
        )
        if (id.value == "") {
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
        }else{
            Button(
                onClick = {
                    val noteEntity = NoteEntity(
                        id = id.value.toInt(),
                        title = title.value,
                        description = description.value
                    )
                    viewModel.update(noteEntity = noteEntity)
                }
            ) {
                Text("Notu güncelle")
            }
        }

        LazyColumn {
            items(notes.value.size){ index ->
                Row {
                    Text(text = notes.value[index].title)
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
//                            viewModel.delete(noteEntity = notes.value[index])
                            viewModel.deleteById(id = notes.value[index].id)
                        }
                    ) {
                        Text("sil")
                    }
                }
            }
        }


    }
}