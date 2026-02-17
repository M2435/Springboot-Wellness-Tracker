package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String mood;
    private String note;
    private String date; // could later be LocalDate

    public Mood() {}

    public Mood(Long userId, String mood, String note, String date) {
        this.userId = userId;
        this.mood = mood;
        this.note = note;
        this.date = date;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
