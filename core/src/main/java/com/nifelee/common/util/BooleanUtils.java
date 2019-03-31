package com.nifelee.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("PMD.UseSingleton")
public final class BooleanUtils {

  public static Boolean toBoolean(String str) {
    if ("1".equals(str)) {
      return true;
    } else if (str == null || "0".equals(str)) {
      return false;
    } else {
      return org.apache.commons.lang3.BooleanUtils.toBoolean(str);
    }
  }

  public static Boolean toBoolean(int i) {
    return org.apache.commons.lang3.BooleanUtils.toBoolean(i);
  }

  public static String toStringYN(boolean bool) {
    return toString(bool, "Y", "N");
  }

  public static String toStringOneZero(boolean bool) {
    return toString(bool, "1", "0");
  }

  public static String toStringTF(boolean bool) {
    return toString(bool, "T", "F");
  }

  public static String toString(boolean bool, String trueString, String falseString) {
    return org.apache.commons.lang3.BooleanUtils.toString(bool, trueString, falseString);
  }
}

