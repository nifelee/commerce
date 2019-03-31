package com.nifelee.commerce.core.repository;

import com.nifelee.commerce.core.domain.Foo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FooRepositoryImplTest {

  @Autowired
  private FooRepository fooRepository;

  @Before
  public void before() {
    Foo foo = Foo.builder()
            .name("FOO")
            .fooType(Foo.FooType.BAR)
            .build();

    fooRepository.save(foo);
  }

  @Test
  public void getAlls() {
    List<Foo> foos = fooRepository.getAlls();
    log.debug("foos : {}", foos);
  }

}