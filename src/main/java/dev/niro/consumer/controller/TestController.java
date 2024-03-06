package dev.niro.consumer.controller;

import dev.niro.consumer.service.TosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
  private TosService tosService;

  @GetMapping
  public Boolean tos() {
    tosService.tos();
    return true;
  }
}
