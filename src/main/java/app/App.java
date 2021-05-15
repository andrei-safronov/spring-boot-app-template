package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Andrei Safronov
 */
@SpringBootApplication
@EnableScheduling
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean(destroyMethod = "shutdown")
  public ExecutorService defaultScheduler() {
    return Executors.newScheduledThreadPool(1);
  }

  @Bean
  public long scheduledTaskInterval() {
    return 3000L;
  }

}
