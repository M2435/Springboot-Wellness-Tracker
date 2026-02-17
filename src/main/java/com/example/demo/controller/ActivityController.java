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

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = "http://localhost:8080")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    // Create new activity
    @PostMapping
    public Activity addActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }

    // Get all activities
    @GetMapping
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    // Get activities by user
    @GetMapping("/user/{userId}")
    public List<Activity> getUserActivities(@PathVariable Long userId) {
        return activityRepository.findByUserId(userId);
    }

    // Update activity
    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found with ID: " + id));
        activity.setType(updatedActivity.getType());
        activity.setDuration(updatedActivity.getDuration());
        activity.setDate(updatedActivity.getDate());
        activity.setUserId(updatedActivity.getUserId());
        return activityRepository.save(activity);
    }

    // Delete activity
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable Long id) {
        activityRepository.deleteById(id);
        return "Activity with ID " + id + " deleted successfully!";
    }
}
