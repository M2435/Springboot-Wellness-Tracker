package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    // Example: find moods by user
    List<Mood> findByUserId(Long userId);
}
