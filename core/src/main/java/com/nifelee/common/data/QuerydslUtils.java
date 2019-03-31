package com.nifelee.common.data;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class QuerydslUtils {

  public static void setOrderBy(JPAQuery query, Pageable pageable) {
    Sort sort = pageable.getSort();
    if (sort instanceof QSort && sort != null) {
      QSort qsort = (QSort) sort;
      List<OrderSpecifier<?>> orderSpecifiers = qsort.getOrderSpecifiers();
      query.orderBy(orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]));
    }
  }

  public static void setOrderBy(JPAQuery query, QSort sort) {
    if (sort != null) {
      List<OrderSpecifier<?>> orderSpecifiers = sort.getOrderSpecifiers();
      query.orderBy(orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]));
    }
  }

  public static void setPage(JPAQuery query, Pageable pageable) {
    query.limit(pageable.getPageSize()).offset(pageable.getOffset());
  }

  public static void setPageAndOrderBy(JPAQuery query, Pageable pageable) {
    setPage(query, pageable);
    setOrderBy(query, pageable);
  }

}
