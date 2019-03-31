package com.nifelee.common.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Comparator;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = "value")
@ToString
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class LabelValue implements Comparable<LabelValue> , Serializable {

  private static final long serialVersionUID = 3689355407466181430L;

  @JsonProperty("label")
  private String label;

  @JsonProperty("value")
  private String value;

  public static final Comparator<LabelValue> CASE_INSENSITIVE_ORDER = (o1, o2) -> {
    String label1 = o1.getLabel();
    String label2 = o2.getLabel();
    return label1.compareToIgnoreCase(label2);
  };

  @QueryProjection
  public LabelValue(final String label, final String value) {
    this.label = label;
    this.value = value;
  }

  @QueryProjection
  public LabelValue(final String label, final Long value) {
    this.label = label;
    this.value = String.valueOf(value);
  }

  @QueryProjection
  public LabelValue(final Long label, final String value) {
    this.label = String.valueOf(label);
    this.value = value;
  }

  public int compareTo(LabelValue labelValue) {
    String label = labelValue.getLabel();

    return this.getLabel().compareTo(label);
  }

}

