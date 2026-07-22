package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.model.Priority;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    public Priority suggestPriority(String title) {

        String text = title.toLowerCase();

        if (text.contains("server")
                || text.contains("fehler")
                || text.contains("bug")
                || text.contains("ausfall")
                || text.contains("kritisch")) {

            return Priority.HIGH;
        }

        if (text.contains("lernen")
                || text.contains("meeting")
                || text.contains("projekt")
                || text.contains("dokumentation")) {

            return Priority.MEDIUM;
        }

        return Priority.LOW;
    }
}