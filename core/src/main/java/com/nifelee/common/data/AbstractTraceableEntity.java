package com.nifelee.common.data;

import com.nifelee.common.data.AbstractCreateTraceableEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.AuditOverride;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@AuditOverride(forClass = AbstractCreateTraceableEntity.class)
public abstract class AbstractTraceableEntity<K extends Serializable, U> extends AbstractCreateTraceableEntity<K, U> {

  private static final long serialVersionUID = 2379933612991151510L;

  @Column(name = "updated_date_time")
  @UpdateTimestamp
  protected LocalDateTime updatedDateTime;

  @Column(name = "updated_by", length = UUID_LENGTH)
  @LastModifiedBy
  protected U updatedBy;

}

