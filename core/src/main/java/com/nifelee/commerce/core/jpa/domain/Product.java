package com.nifelee.commerce.core.jpa.domain;

import com.nifelee.commerce.core.jpa.constants.ColumnSizeConstants;
import com.nifelee.common.data.AbstractTraceableEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tp_product")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
@AuditOverride(forClass = AbstractTraceableEntity.class)
public class Product extends AbstractTraceableEntity<Long, String> {

  private static final long serialVersionUID = 4677053032882362338L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = ColumnSizeConstants.NAME)
  private String name;

}
