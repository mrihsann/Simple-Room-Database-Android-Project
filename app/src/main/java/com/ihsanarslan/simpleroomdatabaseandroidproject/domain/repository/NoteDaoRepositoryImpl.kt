package com.ihsanarslan.simpleroomdatabaseandroidproject.domain.repository

import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteDao
import com.ihsanarslan.simpleroomdatabaseandroidproject.data.local.NoteEntity

class NoteDaoRepositoryImpl(private val noteDao: NoteDao) {

    suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertNote(noteEntity = noteEntity)
    }
}