package de.hgo.demo;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class DemoApplication {

  public static void main(final String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @GetMapping("/hello")
  public void hello(@RequestParam(value = "name", defaultValue = "World") final String name,
      final HttpServletResponse response) throws IOException {

    log.info("Hello for {}", name);

    response.getWriter().print("Hello " + name + "!");
  }
}
