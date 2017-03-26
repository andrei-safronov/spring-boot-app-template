package app.dao;

import app.domain.Greeting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrei Safronov
 */
@Repository
public interface GreetingRepository extends PagingAndSortingRepository<Greeting, Long> {
}
