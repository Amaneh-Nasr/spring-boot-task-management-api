
package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.model.Priority;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class AIService {

    private final RestClient restClient;
    private final String model;

    public AIService(
            @Value("${ollama.base-url}") String baseUrl,
            @Value("${ollama.model}") String model) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();

        this.model = model;
    }

    public Priority suggestPriority(String title) {

        String prompt = """
        You are a task priority classifier.

        Rules:
        - HIGH: production server outage, system failure,
          critical bug, or urgent security problem.
        - MEDIUM: normal project work, meetings, learning,
          or documentation.
        - LOW: minor, non-urgent tasks.

        Classify this task using its title:
        "%s"

        Return exactly one word: HIGH, MEDIUM, or LOW.
        """.formatted(title);

        Map<?, ?> response = restClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of(
                        "model", model,
                        "prompt", prompt,
                        "stream", false,
                        "options", Map.of(
                                "temperature", 0
                        )
                ))
                .retrieve()
                .body(Map.class);

        if (response == null
                || !(response.get("response") instanceof String result)) {
            throw new IllegalStateException(
                    "Invalid response from Ollama");
        }

        String answer = result.trim().toUpperCase();
        System.out.println("Ollama-Antwort: " + answer);

        return switch (answer) {
            case "HIGH" -> Priority.HIGH;
            case "MEDIUM" -> Priority.MEDIUM;
            case "LOW" -> Priority.LOW;
            default -> throw new IllegalStateException(
                    "Ollama returned an invalid priority: " + result);
        };
    }
}
