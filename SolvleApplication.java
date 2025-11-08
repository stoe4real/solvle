package c.a.solvle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc  // ← This forces MVC configuration (safe to add)
public class SolvleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolvleApplication.class, args);
    }
}
