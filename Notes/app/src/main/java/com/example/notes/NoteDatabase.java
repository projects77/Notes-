package com.example.notes;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

private  static NoteDatabase instance;

public abstract NoteDao noteDao();

public static synchronized NoteDatabase getInstance(Context context){
    if(instance==null){
        instance= Room.databaseBuilder(context.getApplicationContext(),
                NoteDatabase.class,"note_Database").
                fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build();
    }
    return instance;
}
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new dbAsyncTask(instance).execute();
        }
    };
    private static class dbAsyncTask extends AsyncTask<Void,Void,Void>
    {
      private NoteDao noteDao;
      private dbAsyncTask(NoteDatabase db){
      noteDao=db.noteDao();
      }
        @Override
        protected Void doInBackground(Void... voids) {

          noteDao.insert(new Note("title 1","details1"));
          noteDao.insert(new Note("title 2","details2"));
          noteDao.insert(new Note("title 3","details3"));
          noteDao.insert(new Note("title 4","details4"));
          noteDao.insert(new Note("title 5","details5"));

            return null;
        }
    }


}
