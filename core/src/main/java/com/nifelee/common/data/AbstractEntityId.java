package com.nifelee.common.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude
public abstract class AbstractEntityId implements Serializable {

  private static final long serialVersionUID = -2053668818011263946L;

  public abstract String toString();

  public abstract boolean equals(Object o);

  public abstract int hashCode();

}

