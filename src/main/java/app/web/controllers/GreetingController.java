package app.web.controllers;

import app.domain.Greeting;
import app.services.GreetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrei Safronov
 */
@RestController
public class GreetingController {

  @Autowired
  private GreetingService service;

  @RequestMapping(value = "/greetings", method = RequestMethod.GET)
  public List<Greeting> getGreetings(@RequestParam(value = "page", defaultValue = "0") int pageNumber,
      @RequestParam(value = "size", defaultValue = "10") int pageSize) {
    return service.getGreetings(pageNumber, pageSize);
  }

  @RequestMapping(value = "/greetings", method = RequestMethod.POST)
  public Greeting saveGreeting(@RequestBody() Greeting greeting) {
    return service.saveGreeting(greeting);
  }

}
