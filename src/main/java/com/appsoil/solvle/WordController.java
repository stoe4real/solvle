package com.appsoil.solvle;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WordController {

    /**
     * Returns the full word list as JSON: { "words": [ ... ] }
     * The file is loaded from src/main/resources/dict2/enable1.txt
     */
    @GetMapping("/api/words")
    public Map<String, List<String>> getWordlist() {
        String filePath = "dict2/enable1.txt";   // <-- correct folder

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new ClassPathResource(filePath).getInputStream()))) {

            List<String> words = reader.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            Map<String, List<String>> response = new HashMap<>();
            response.put("words", words);
            return response;

        } catch (Exception e) {
            // If the file is missing we still return a tiny list so the UI can start
            List<String> fallback = List.of("apple", "crane", "slate", "audio", "trace");
            Map<String, List<String>> response = new HashMap<>();
            response.put("words", fallback);
            return response;
        }
    }
}
