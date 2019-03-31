package com.nifelee.common.data;

import org.hibernate.dialect.SQLServerDialect;

import java.sql.Types;

public class SQLServerDialectCustom extends SQLServerDialect {

  private static final int MAX_LENGTH = 8000;

  public SQLServerDialectCustom() {
    registerHibernateType(Types.NVARCHAR, "string");
    registerColumnType( Types.VARCHAR, "nvarchar(MAX)" );
    registerColumnType( Types.VARCHAR, MAX_LENGTH, "nvarchar($l)" );
    registerColumnType(Types.CLOB, "nvarchar(MAX)" );
  }

}

