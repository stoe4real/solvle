package c.a.solvle;

import c.a.solvle.config.SolvleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AnalyzeController {

    @Autowired
    private SolvleConfig config;

    @GetMapping("/analyze")
    public Map<String, List<String>> analyze(@RequestParam String word) {
        // Simple analysis logic (green/yellow/gray for Wordle-style)
        // This is a basic implementation – adjust as needed
        String solution = config.getRandomSolution(); // Get a random solution word from config
        Map<String, List<String>> result = new HashMap<>();
        result.put("correct", new ArrayList<>());
        result.put("present", new ArrayList<>());
        result.put("absent", new ArrayList<>());

        for (int i = 0; i < word.length(); i++) {
            char guessChar = word.charAt(i);
            char solChar = solution.charAt(i);
            if (guessChar == solChar) {
                result.get("correct").add(Character.toString(guessChar));
            } else if (solution.contains(Character.toString(guessChar))) {
                result.get("present").add(Character.toString(guessChar));
            } else {
                result.get("absent").add(Character.toString(guessChar));
            }
        }

        return result;
    }
}
