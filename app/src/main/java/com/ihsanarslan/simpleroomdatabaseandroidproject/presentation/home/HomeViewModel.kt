package com.ihsanarslan.simpleroomdatabaseandroidproject.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteDatabase
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteEntity
import com.ihsanarslan.simpleroomdatabaseandroidproject.domain.repository.NoteDaoRepositoryImpl
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val database = NoteDatabase.Companion.getDatabase(application)

    private val repository : NoteDaoRepositoryImpl

    val notes : LiveData<List<NoteEntity>>


    init {

        val noteDao = database.noteDao()
        repository = NoteDaoRepositoryImpl(noteDao)
        notes = repository.getAllNotes()
    }

    fun insert(noteEntity: NoteEntity){
        viewModelScope.launch {
            repository.insertNote(noteEntity = noteEntity)
        }
    }
}