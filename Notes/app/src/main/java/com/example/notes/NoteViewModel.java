package com.example.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void Insert(Note note) {
        repository.Insert(note);
    }

    public void Update(Note note) {
        repository.Update(note);
    }

    public void delete(Note note) {
        repository.Delete(note);
    }

    public void DeleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>>getAllNotes() {
        return allNotes;

    }
}