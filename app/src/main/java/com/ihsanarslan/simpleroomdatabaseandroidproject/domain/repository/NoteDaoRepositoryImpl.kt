package com.ihsanarslan.simpleroomdatabaseandroidproject.domain.repository

import androidx.lifecycle.LiveData
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteDao
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteEntity

class NoteDaoRepositoryImpl(private val noteDao: NoteDao) {

    suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertNote(noteEntity = noteEntity)
    }

    fun getAllNotes() : LiveData<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    suspend fun deleteNote(noteEntity : NoteEntity) {
        noteDao.deleteNote(noteEntity = noteEntity)
    }

    suspend fun deleteNoteById(id : Int) {
        noteDao.deleteNoteById(id = id)
    }

    suspend fun updateNote(noteEntity: NoteEntity) {
        noteDao.updateNote(noteEntity = noteEntity)
    }


}