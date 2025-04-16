package com.ihsanarslan.simpleroomdatabaseandroidproject.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDao{

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

}