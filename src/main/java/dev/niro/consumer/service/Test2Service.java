package dev.niro.consumer.service;

import dev.niro.consumer.model.Test1;
import dev.niro.consumer.repository.Test2Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class Test2Service {
  private Test2Repository test2Repository;

  public Test1 getById(Integer id) {
    return test2Repository.findById(id)
            .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test1 notfound"));
  }

  public Test1 create(Test1 test1){
    return test2Repository.create(test1);
  }
}
