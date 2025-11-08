package com.appsoil.solve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AnalyzeController {

    @GetMapping("/analyze")
    public Map<String, List<String>> analyze(@RequestParam String word) {
        // Simple test response
        Map<String, List<String>> result = new HashMap<>();
        result.put("correct", List.of("C"));
        result.put("present", List.of("R", "A", "N", "E"));
        result.put("absent", new ArrayList<>());
        return result;
    }
}
