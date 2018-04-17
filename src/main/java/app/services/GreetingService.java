package app.services;

import app.aspects.annotations.Loggable;
import app.dao.GreetingRepository;
import app.domain.Greeting;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * @author Andrei Safronov
 */
@Service
public class GreetingService {

  @Autowired
  private GreetingRepository repository;

  @Loggable
  public List<Greeting> getGreetings(int pageNumber, int pageSize) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, new Sort(new Order(Direction.ASC, "id")));
    Page<Greeting> page = repository.findAll(pageRequest);
    return page.getContent();
  }

  @Loggable
  public Greeting saveGreeting(Greeting greeting) {
    return repository.save(greeting);
  }
}
