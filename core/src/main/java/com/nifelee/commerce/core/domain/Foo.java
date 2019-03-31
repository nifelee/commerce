package com.nifelee.commerce.core.domain;

import com.nifelee.common.data.AbstractTimestampEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foo")
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
public class Foo extends AbstractTimestampEntity<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "foo_type", length = 5)
  private FooType fooType;

  @Builder
  public Foo(String name, FooType fooType) {
    this.name = name;
    this.fooType = fooType;
  }

  public static enum FooType {
    FOO,
    BAR
  }

}
