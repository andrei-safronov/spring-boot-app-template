package app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ScheduledTasksService {

  private static final Logger logger = LoggerFactory.getLogger(ScheduledTasksService.class);

  @Scheduled(fixedDelayString = "#{@scheduledTaskInterval}")
  public void execute() {
    logger.info("Scheduled execution at {}", LocalTime.now());
  }
}
