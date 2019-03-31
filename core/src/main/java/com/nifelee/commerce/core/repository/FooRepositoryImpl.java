package com.nifelee.commerce.core.repository;

import com.nifelee.commerce.core.domain.Foo;
import com.nifelee.commerce.core.domain.QFoo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FooRepositoryImpl implements FooRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Foo> getAlls() {
    QFoo foo = QFoo.foo;
    return jpaQueryFactory.selectFrom(foo)
      .where(foo.name.like("%"))
      .orderBy(foo.id.asc())
      .fetch();
  }

}
