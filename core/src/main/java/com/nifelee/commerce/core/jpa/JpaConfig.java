package com.nifelee.commerce.core.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.configuration.DatabaseConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Optional;
import java.util.regex.Pattern;

@Configuration
@EnableJpaRepositories(basePackages = "com.nifelee.commerce.core.jpa.repository",
    includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, value = JpaConfig.JpaRepositoryFilter.class))
@EntityScan(basePackages = "com.nifelee.commerce.core.jpa.domain")
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaConfig {

  private final DataSource dataSource;

  @PersistenceContext
  private EntityManager entityManager;

  @Bean
  public JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(entityManager);
  }

  @Bean
  public AuditorAware<String> auditorAware() {
    return new SpringSecurityAuditorAware();
  }

  @Bean
  public DatabaseConfiguration dbConfig() {
    return new DatabaseConfiguration(dataSource, "tz_config", "id", "value");
  }

  static class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
      //TODO : get current login user
/*
      User user = getCurrentUser();
      return user == null ? null : user.getId();
    }

    private User getCurrentUser() {
      User user = null;

      try {
        user = SecurityUtils.getCurrentUser();
      } catch (RuntimeException e) {
        //ignore
      }

      return user;
*/
      return Optional.empty();
    }
  }

  public static class JpaRepositoryFilter extends RegexPatternTypeFilter {
    public JpaRepositoryFilter() {
      super(Pattern.compile(".*(?i)\\.jpa.repository.*"));
    }
  }

}
