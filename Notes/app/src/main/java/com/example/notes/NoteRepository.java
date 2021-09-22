package com.example.notes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database= NoteDatabase.getInstance(application);
        noteDao= database.noteDao();
        allNotes=noteDao.getAllNotes();


    }

    public void Insert(Note note){
    new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void Update(Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public void Delete(Note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public void setAllNotes(LiveData<List<Note>> allNotes) {
        this.allNotes = allNotes;
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void deleteAllNotes() {
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void> {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }}
        private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void> {
            private NoteDao noteDao;

            private UpdateNoteAsyncTask(NoteDao noteDao) {
                this.noteDao = noteDao;
            }

            @Override
            protected Void doInBackground(Note... notes) {
                noteDao.update(notes[0]);
                return null;
            }

        }

            private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void> {
                private NoteDao noteDao;

                private DeleteNoteAsyncTask(NoteDao noteDao) {
                    this.noteDao = noteDao;
                }

                @Override
                protected Void doInBackground(Note... notes) {
                    noteDao.delete(notes[0]);
                    return null;
                }
            }


                private static class DeleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>{
                    private NoteDao noteDao;

                    private DeleteAllNotesAsyncTask(NoteDao noteDao) {
                        this.noteDao=noteDao;
                    }

                    @Override
                    protected Void doInBackground(Void... Voids) {
                        noteDao.deleteAllNotes();
                        return null;
                    }
















    }





}
