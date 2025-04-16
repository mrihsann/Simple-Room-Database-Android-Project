package com.ihsanarslan.simpleroomdatabaseandroidproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao{

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM Notes ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<NoteEntity>>

}