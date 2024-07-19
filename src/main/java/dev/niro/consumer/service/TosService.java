package dev.niro.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import dev.niro.consumer.model.Test1;

@Service
public class TosService {
  @Autowired
  private Test1Service test1Service;
  @Autowired
  private Test2Service test2Service;

  @Autowired
  private PlatformTransactionManager transactionManager1;

  @Autowired
  private PlatformTransactionManager transactionManager2;

  @Transactional(transactionManager = "transactionManager1")
  public void test1() {
    Test1 test1 = new Test1();
    test1.setName("punten2");
    test1 = test1Service.create(test1);
    System.out.println(test1.toString());
  }

  @Transactional(transactionManager = "transactionManager2")
  public void test2() throws Exception {
    Test1 tes2 = new Test1();
    tes2.setName("tos");
    // tes2.setName(null);
    tes2 = test2Service.create(tes2);
    System.out.println(tes2.toString());
    System.out.println("tos");
    // throw new Exception("Invalid response: test2");
  }

  // public void tos() throws Exception {
  //   TransactionStatus status1 = transactionManager1.getTransaction(new DefaultTransactionDefinition());
  //   TransactionStatus status2 = transactionManager2.getTransaction(new DefaultTransactionDefinition());
  //   try {
  //     test1();
  //     test2();
  //     transactionManager1.commit(status1);
  //     transactionManager2.commit(status2);
  //   } catch (Exception ex) {
  //     System.out.println("11111111111111111111111111111");
  //     transactionManager1.rollback(status1);
  //     System.out.println("2222222222222222222222222222222");
  //     transactionManager2.rollback(status2);
  //     System.out.println("33333333333333333333333333333");
  //     throw ex; // atau bisa melakukan handling exception yang sesuai
  //   }
  // }
  @Transactional("chainedTransactionManager")
  public void tos() throws Exception{
    if (true == true)
      test1();
    test2();
  }
}