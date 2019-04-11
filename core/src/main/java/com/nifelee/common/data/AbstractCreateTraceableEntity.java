package com.nifelee.common.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@AuditOverride(forClass = AbstractCreateTimestampEntity.class)
public abstract class AbstractCreateTraceableEntity<K extends Serializable, U> extends AbstractCreateTimestampEntity<K> {

  private static final long serialVersionUID = -6279828398703077543L;

  @Column(name = "created_by", updatable = false, length = UUID_LENGTH)
  @CreatedBy
  protected U createdBy;

}

