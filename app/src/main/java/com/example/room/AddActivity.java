package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE="com.example.room.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION="com.example.room.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY="com.example.room.EXTRA_PRIORITY";

    private EditText title_text;
    private  EditText description_text;
    private NumberPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_text=findViewById(R.id.title);
        description_text=findViewById(R.id.description);
        picker=findViewById(R.id.picker);
        picker.setMinValue(1);
        picker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
        setTitle("Add Note");
    }

    private void saveNote(){
        String title=title_text.getText().toString();
        String description=description_text.getText().toString();
        int priority=picker.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
        }
        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
