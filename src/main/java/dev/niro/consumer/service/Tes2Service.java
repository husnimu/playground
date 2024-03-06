package dev.niro.consumer.service;

import dev.niro.consumer.model.Tes2;
import dev.niro.consumer.repository.Tes2Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class Tes2Service {
  private Tes2Repository tes2Repository;

  public Tes2 getById(Integer id) {
    return tes2Repository.findById(id)
            .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tes2 notfound"));
  }

  @Transactional
  public Tes2 create(Tes2 tes2){
    return tes2Repository.create(tes2);
  }
}
