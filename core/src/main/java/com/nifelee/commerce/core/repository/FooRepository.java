package com.nifelee.commerce.core.repository;

import com.nifelee.commerce.core.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long>, FooRepositoryCustom {
}
