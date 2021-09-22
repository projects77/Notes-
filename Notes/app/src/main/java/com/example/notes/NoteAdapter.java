package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.text_Title.setText(currentNote.getTitle());
        holder.text_Details.setText(currentNote.getDetails());

    }
    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }



    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView text_Title;
        private TextView text_Details;


        public NoteHolder(View itemView) {
            super(itemView);
            text_Title = itemView.findViewById(R.id.text_title);
            text_Details = itemView.findViewById(R.id.text_details);

        }
    }}