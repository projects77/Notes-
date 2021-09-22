package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText edit_Title;
    private EditText edit_Details;

    public static final String EXTRA_TITLE =
            "com.example.notes.EXTRA_TITLE";
    public static final String EXTRA_DETAILS =
            "com.example.notes.EXTRA_DETAILS";





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edit_Title = findViewById(R.id.edit_title);
        edit_Details = findViewById(R.id.edit_details);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }


    private void saveNote() {
        String title = edit_Title.getText().toString();
        String details = edit_Details.getText().toString();

        if (title.trim().isEmpty() || details.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and details", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DETAILS, details);

        setResult(RESULT_OK, data);
        finish();
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}