package com.nifelee.commerce.core.jpa.domain;

import com.nifelee.commerce.core.jpa.constants.ColumnSizeConstants;
import com.nifelee.common.data.AbstractTraceableEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tu_user")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
@AuditOverride(forClass = AbstractTraceableEntity.class)
public class User extends AbstractTraceableEntity<String, String> {

  private static final long serialVersionUID = -7007647000281699799L;

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(length = ColumnSizeConstants.UUID)
  private String id;

  @Column(name = "username", length = ColumnSizeConstants.NAME, unique = true)
  private String username;

  @Column(name = "last_name", length = ColumnSizeConstants.NAME, nullable = false)
  private String lastName;

  @Column(name = "first_name", length = ColumnSizeConstants.NAME, nullable = false)
  private String firstName;

  @Setter
  @Column(length = ColumnSizeConstants.PASSWORD, nullable = false)
  @NotAudited
  private String password;

  @Column
  private boolean enabled;

  @Column(name = "account_expired")
  private boolean accountExpired;

  @Column(name = "account_locked")
  private boolean accountLocked;

  @Column(name = "account_lock_date_time")
  private LocalDateTime accountLockDateTime;

  @Column(name = "login_failure_count")
  private int loginFailureCount;

  @Column(name = "init_password")
  private boolean initPassword;

  @Column(name = "join_date_time")
  private LocalDateTime joinDateTime;

  @Column(name = "last_login_date_time")
  @NotAudited
  private LocalDateTime lastLoginDateTime;

  @Builder
  public User(String username, String lastName, String firstName, String password, boolean enabled) {
    this.username = username;
    this.lastName = lastName;
    this.firstName = firstName;
    this.password = password;
    this.enabled = enabled;

    this.initPassword = true;
  }

  public boolean isAccountNonExpired() {
    return !accountExpired;
  }

  public boolean isAccountNonLocked() {
    return !accountLocked;
  }

  public void addLoginFailureCount() {
    this.loginFailureCount += 1;
  }

  public void accountLock() {
    this.accountLocked = true;
    this.accountLockDateTime = LocalDateTime.now();
  }

  public void clearAccountLock() {
    this.loginFailureCount = 0;
    this.accountLocked = false;
    this.accountLockDateTime = null;
  }

  public void updateLoginDateTime() {
    LocalDateTime currentDateTime = LocalDateTime.now();

    if (this.joinDateTime == null)
      this.joinDateTime = currentDateTime;

    this.lastLoginDateTime = currentDateTime;
  }

}
