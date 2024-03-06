package dev.niro.consumer.service;

import dev.niro.consumer.model.Test1;
import dev.niro.consumer.repository.Test1Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class Test1Service {
  private Test1Repository test1Repository;

  public Test1 getById(Integer id) {
    return test1Repository.findById(id)
            .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test1 notfound"));
  }

  @Transactional
  public Test1 create(Test1 test1){
    return test1Repository.create(test1);
  }
}
