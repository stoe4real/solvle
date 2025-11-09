package com.appsoil.solvle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WordController {

    @GetMapping("/api/words")
    public List<String> getWordlist() {
        String filePath = "dict2/enable1.txt";  // CORRECT PATH
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ClassPathResource(filePath).getInputStream()))) {
            return reader.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return List.of("apple", "crane", "slate", "audio", "trace");
        }
    }
}
