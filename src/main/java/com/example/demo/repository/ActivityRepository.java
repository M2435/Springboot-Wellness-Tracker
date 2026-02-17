package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // Example: find activities by user
    List<Activity> findByUserId(Long userId);
}
