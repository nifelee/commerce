package com.nifelee.common.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTraceableEntity<K extends Serializable, U> extends AbstractCreateTraceableEntity<K, U> {

  private static final long serialVersionUID = 2379933612991151510L;

  @Column(name = "updated_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  protected LocalDateTime updatedDateTime;

  @Column(name = "updated_by", length = UUID_LENGTH)
  @LastModifiedBy
  protected U updatedBy;

}

