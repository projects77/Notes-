package com.example.notes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.nio.file.attribute.AclEntryPermission;
import java.util.List;

import static android.os.FileObserver.DELETE;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);


    @Query("DELETE FROM note_table")
    void deleteAllNotes();
    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getAllNotes();
}
