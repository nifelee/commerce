package com.nifelee.common.data;

import org.hibernate.dialect.MySQL5InnoDBDialect;

import java.sql.Types;

public class MySQL5InnoDBDialectCustom extends MySQL5InnoDBDialect {

  public MySQL5InnoDBDialectCustom() {
    super();
    registerColumnType(Types.DATE, "datetime");
    registerColumnType(Types.TIMESTAMP, "datetime(3)");
  }

}

