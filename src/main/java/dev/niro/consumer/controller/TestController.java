package dev.niro.consumer.controller;

import dev.niro.consumer.service.TosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@AllArgsConstructor
public class TestController {
  private TosService tosService;

  @GetMapping
  public Boolean tos() throws Exception {
    tosService.tos();
    return true;
  }
}
