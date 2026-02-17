package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Mood;
import com.example.demo.repository.MoodRepository;

@RestController
@RequestMapping("/moods")
@CrossOrigin(origins = "http://localhost:8080")
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    // Create new mood
    @PostMapping
    public Mood addMood(@RequestBody Mood mood) {
        return moodRepository.save(mood);
    }

    // Get all moods
    @GetMapping
    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }

    // Get moods by user
    @GetMapping("/user/{userId}")
    public List<Mood> getUserMoods(@PathVariable Long userId) {
        return moodRepository.findByUserId(userId);
    }

    // Get mood by ID
    @GetMapping("/{id}")
    public Mood getMoodById(@PathVariable Long id) {
        return moodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mood not found with ID: " + id));
    }

    // Update mood
    @PutMapping("/{id}")
    public Mood updateMood(@PathVariable Long id, @RequestBody Mood updatedMood) {
        Mood mood = moodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mood not found with ID: " + id));
        mood.setMood(updatedMood.getMood());
        mood.setNote(updatedMood.getNote());
        mood.setDate(updatedMood.getDate());
        mood.setUserId(updatedMood.getUserId());
        return moodRepository.save(mood);
    }

    // Delete mood
    @DeleteMapping("/{id}")
    public String deleteMood(@PathVariable Long id) {
        moodRepository.deleteById(id);
        return "Mood with ID " + id + " deleted successfully!";
    }
}
