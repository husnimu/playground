package dev.niro.consumer.service;

import dev.niro.consumer.model.Tes2;
import dev.niro.consumer.model.Test1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TosService {
  private Test1Service test1Service;
  private Tes2Service tes2Service;

//  @Transactional
  public void tos(){
    Test1 test1 = new Test1();
    test1.setName("punten1");
    test1 = test1Service.create(test1);
    System.out.println(test1.toString());

    Tes2 tes2 = new Tes2();
    tes2.setIdTest1(test1.getId());
    tes2.setName("punten2");
    System.out.println(tes2.toString());
    tes2 = tes2Service.create(tes2);
    System.out.println(tes2.toString());

    System.out.println("tos");
  }
}
