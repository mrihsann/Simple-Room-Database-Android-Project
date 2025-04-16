package com.ihsanarslan.simpleroomdatabaseandroidproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao{

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM Notes ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<NoteEntity>>

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("DELETE FROM Notes WHERE id = :id")
    suspend fun deleteNoteById(id : Int)

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)
}