package com.nifelee.common.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = JsonInclude.Include.ALWAYS)
public abstract class AbstractEntity<K extends Serializable> implements Serializable {

  private static final long serialVersionUID = 5534003885658026617L;

  public static final int UUID_LENGTH = 50;

  //public abstract String toString();

  public abstract K getId();

}

