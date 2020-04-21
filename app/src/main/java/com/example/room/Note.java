package com.example.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="note_table")
public class Note {
    private String title;
    private String description;

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}
