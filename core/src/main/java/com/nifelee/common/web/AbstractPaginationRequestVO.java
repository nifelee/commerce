package com.nifelee.common.web;

import com.querydsl.core.types.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class AbstractPaginationRequestVO extends RequestVO {

  private static final long serialVersionUID = 1287898189924576790L;

  private static final int DEFAULT_PAGE_ROW = 20;

  private int page;

  private int pageRows;

  @Getter
  private String sort;

  protected Order order;

  public int getPage() {
    return page < 1 ? 1 : page;
  }

  public int getPageRows() {
    return pageRows <= 0 ? DEFAULT_PAGE_ROW : pageRows;
  }

  public abstract QSort getQSort();

  public Pageable getPageable() {
    return new QPageRequest(getPage() - 1, getPageRows(), getQSort());
  }

  public Order getOrder() {
    return order == null ? Order.DESC : order;
  }

}
