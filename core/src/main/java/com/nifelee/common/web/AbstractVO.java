package com.nifelee.common.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nifelee.common.util.JsonUtils;
import com.nifelee.common.util.StringUtils;
import com.nifelee.common.util.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public abstract class AbstractVO implements Serializable {

  private static final long serialVersionUID = 3020099809799695676L;

  public abstract String toString();

  public String reflectionToString() {
    return StringUtils.toString(this);
  }

  public String toJsonString() {
    return JsonUtils.toString(this);
  }

  public String toXmlString() {
    return XmlUtils.toString(this);
  }

}

