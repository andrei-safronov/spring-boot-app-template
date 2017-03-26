package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Andrei Safronov
 */
@Entity
public class Greeting {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String content;

  public Greeting() {
  }

  public Greeting(Long id, String content) {
    this.id = id;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
