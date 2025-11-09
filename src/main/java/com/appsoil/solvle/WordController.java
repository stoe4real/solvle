package com.appsoil.solvle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WordController {

    @GetMapping("/api/words")
    public List<String> getWords() {
        String path = "dict/enable1.txt";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)))) {
            return br.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return List.of("apple", "crane", "slate", "audio", "trace");
        }
    }
}
