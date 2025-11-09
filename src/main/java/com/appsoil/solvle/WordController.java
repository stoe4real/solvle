package com.appsoil.solvle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WordController {

    @Autowired
    private SolvleConfig config;

    @GetMapping("/api/words")
    public List<String> getWordlist() {
        // Load from default dict file (e.g., enable1.txt – adjust path if needed)
        String filePath = "dict/enable1.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath)))) {
            return reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            return List.of(); // Empty list on error
        }
    }
}
