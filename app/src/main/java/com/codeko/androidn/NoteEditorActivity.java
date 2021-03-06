package com.codeko.androidn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {

            editText.setText(NotesActivity.notes.get(noteId));

        } else {

            NotesActivity.notes.add("");
            noteId = NotesActivity.notes.size() - 1;
            NotesActivity.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                NotesActivity.notes.set(noteId, String.valueOf(charSequence));
                NotesActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.codeko.androidn", Context.MODE_PRIVATE);

                HashSet<String> set = new HashSet(NotesActivity.notes);

                sharedPreferences.edit().putStringSet("notes", set).apply();



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}

