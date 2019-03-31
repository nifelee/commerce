package com.nifelee.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

  public static boolean isEmpty(String str) {
    return org.apache.commons.lang3.StringUtils.isEmpty(str);
  }

  public static boolean isNotEmpty(String str) {
    return org.apache.commons.lang3.StringUtils.isNotEmpty(str);
  }

  public static boolean isBlank(String str) {
    return org.apache.commons.lang3.StringUtils.isBlank(str);
  }

  public static boolean isNotBlank(String str) {
    return org.apache.commons.lang3.StringUtils.isNotBlank(str);
  }

  public static String replace(String text, String searchString, String replacement) {
    return org.apache.commons.lang3.StringUtils.replace(text, searchString, replacement);
  }

  public static String remove(String str, String removeString) {
    return org.apache.commons.lang3.StringUtils.remove(str, removeString);
  }

  public static String removeEnd(String str, String remove) {
    return org.apache.commons.lang3.StringUtils.removeEnd(str, remove);
  }

  public static String substring(String str, int start, int end) {
    return org.apache.commons.lang3.StringUtils.substring(str, start, end);
  }

  public static int indexOf(String str, String searchStr) {
    return org.apache.commons.lang3.StringUtils.indexOf(str, searchStr);
  }

  public static String trim(String str) {
    return org.apache.commons.lang3.StringUtils.trimToEmpty(str);
  }

  public static String deleteWhitespace(String str) {
    return org.apache.commons.lang3.StringUtils.deleteWhitespace(str);
  }

  public static String defaultString(String str) {
    return org.apache.commons.lang3.StringUtils.defaultString(str);
  }

  public static String defaultString(String str, String defaultStr) {
    return org.apache.commons.lang3.StringUtils.defaultString(str, defaultStr);
  }

  public static String defaultIfBlank(String str, String defaultStr) {
    return org.apache.commons.lang3.StringUtils.defaultIfBlank(str, defaultStr);
  }

  public static boolean containsIgnoreCase(String str, String searchStr) {
    return org.apache.commons.lang3.StringUtils.containsIgnoreCase(str, searchStr);
  }

  public static String lowerCase(String str) {
    return org.apache.commons.lang3.StringUtils.lowerCase(str);
  }

  public static String upperCase(String str) {
    return org.apache.commons.lang3.StringUtils.upperCase(str);
  }

  public static boolean contains(String str, String searchString) {
    return org.apache.commons.lang3.StringUtils.contains(str, searchString);
  }

  public static boolean containsAny(String str, String... searchStrings) {
    for (String arg : searchStrings) {
      if (contains(str, arg))
        return true;
    }

    return false;
  }

  public static boolean startsWith(String str, String prefix) {
    return org.apache.commons.lang3.StringUtils.startsWith(str, prefix);
  }

  public static boolean startsWithAny(String str, String... prefix) {
    return org.apache.commons.lang3.StringUtils.startsWithAny(str, prefix);
  }

  public static String[] split(String str, String delim) {
    return org.apache.commons.lang3.StringUtils.split(str, delim);
  }

  public static String[] split(String str, String delim, int max) {
    return org.apache.commons.lang3.StringUtils.split(str, delim, max);
  }

  public static String join(Object[] array, String seperator) {
    return org.apache.commons.lang3.StringUtils.join(array, seperator);
  }

  public static boolean equals(CharSequence str1, CharSequence str2) {
    return org.apache.commons.lang3.StringUtils.equalsIgnoreCase((String) str1, (String) str2);
  }

  public static String left(String str, int len) {
    return org.apache.commons.lang3.StringUtils.left(str, len);
  }

  public static String right(String str, int len) {
    return org.apache.commons.lang3.StringUtils.right(str, len);
  }

  public static String substringBetween(String str, String open, String close) {
    return org.apache.commons.lang3.StringUtils.substringBetween(str, open, close);
  }

  public static String substringAfterLast(String str, String separator) {
    return org.apache.commons.lang3.StringUtils.substringAfterLast(str, separator);
  }

  public static String substringAfter(String str, String separator) {
    return org.apache.commons.lang3.StringUtils.substringAfter(str, separator);
  }

  public static String substringBefore(String str, String separator) {
    return org.apache.commons.lang3.StringUtils.substringBefore(str, separator);
  }

  public static String substringBeforeLast(String str, String separator) {
    return org.apache.commons.lang3.StringUtils.substringBeforeLast(str, separator);
  }

  public static String toString(Object object) {
    return ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE);
  }

  public static String removeStart(String str, String remove) {
    return org.apache.commons.lang3.StringUtils.removeStart(str, remove);
  }
}

