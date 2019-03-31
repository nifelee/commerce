package com.nifelee.common.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude
public class RequestVO extends AbstractVO {

  private static final long serialVersionUID = 6597357454848960213L;

}
