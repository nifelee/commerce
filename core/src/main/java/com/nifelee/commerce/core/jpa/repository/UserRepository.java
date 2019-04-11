package com.nifelee.commerce.core.jpa.repository;

import com.nifelee.commerce.core.jpa.domain.User;
import com.nifelee.common.data.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, String>, UserRepositoryCustom {
}
