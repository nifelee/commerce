package com.nifelee.common.util;

import com.nifelee.common.Constants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ByteUtils {

  public static byte toByte(String value, byte defaultValue) {
    try {
      return Byte.parseByte(value);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static int unsignedByte(byte b) {
    return b & 0xFF;
  }

  public static int toInt(byte[] src, int srcPos) {
    int dword = 0;
    for (int i = 0; i < 4; i++) {
      dword = (dword << 8) + (src[i + srcPos] & 0xFF);
    }
    return dword;
  }

  public static int toInt(byte[] src) {
    return toInt(src, 0);
  }

  public static long toLong(byte[] src, int srcPos) {
    long qword = 0;
    for (int i = 0; i < 8; i++) {
      qword = (qword << 8) + (src[i + srcPos] & 0xFF);
    }
    return qword;
  }

  public static long toLong(byte[] src) {
    return toLong(src, 0);
  }

  public static void toBytes(int value, byte[] dest, int destPos) {
    for (int i = 0; i < 4; i++) {
      dest[i + destPos] = (byte) (value >> ((7 - i) * 8));
    }
  }

  public static byte[] toBytes(int value) {
    byte[] dest = new byte[4];
    toBytes(value, dest, 0);
    return dest;
  }

  public static byte[] toBytes(String value) {
    try {
      return value.getBytes(Constants.DEFAULT_CHAR_SET);
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex);
    }
  }

  public static void toBytes(long value, byte[] dest, int destPos) {
    for (int i = 0; i < 8; i++) {
      dest[i + destPos] = (byte) (value >> ((7 - i) * 8));
    }
  }

  public static byte[] toBytes(long value) {
    byte[] dest = new byte[8];
    toBytes(value, dest, 0);
    return dest;
  }

  public static byte[] toBytes(String digits, int radix) throws IllegalArgumentException, NumberFormatException {
    if (digits == null)
      return null;

    if (radix != 16 && radix != 10 && radix != 8)
      throw new IllegalArgumentException("For input radix: \"" + radix + "\"");

    int divLen = (radix == 16) ? 2 : 3;
    int length = digits.length();
    if (length % divLen == 1)
      throw new IllegalArgumentException("For input string: \"" + digits + "\"");

    length = length / divLen;
    byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++) {
      int index = i * divLen;
      bytes[i] = (byte) (Short.parseShort(digits.substring(index, index + divLen), radix));
    }

    return bytes;
  }

  public static byte[] toBytesFromHexString(String digits) throws IllegalArgumentException, NumberFormatException {
    if (digits == null)
      return null;

    int length = digits.length();
    if (length % 2 != 0)
      throw new IllegalArgumentException("For input string: \"" + digits + "\"");

    length = length / 2;
    byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++) {
      int index = i * 2;
      bytes[i] = (byte) (Short.parseShort(digits.substring(index, index + 2), 16));
    }

    return bytes;
  }

  public static String toHexString(byte b) {
    StringBuilder result = new StringBuilder(3);
    result.append(Integer.toString((b & 0xF0) >> 4, 16));
    result.append(Integer.toString(b & 0x0F, 16));
    return result.toString();
  }

  public static String toHexString(byte[] bytes) {
    if (bytes == null)
      return null;

    StringBuilder result = new StringBuilder();
    for (byte b : bytes) {
      result.append(Integer.toString((b & 0xF0) >> 4, 16));
      result.append(Integer.toString(b & 0x0F, 16));
    }

    return result.toString();
  }

  public static String toHexString(byte[] bytes, int offset, int length) {
    if (bytes == null)
      return null;

    StringBuilder result = new StringBuilder();
    for (int i = offset; i < offset + length; i++) {
      result.append(Integer.toString((bytes[i] & 0xF0) >> 4, 16));
      result.append(Integer.toString(bytes[i] & 0x0F, 16));
    }

    return result.toString();
  }

  public static boolean equals(byte[] array1, byte[] array2) {
    if (array1 == array2)
      return true;

    if (array1 == null || array2 == null)
      return false;

    if (array1.length != array2.length)
      return false;

    for (int i = 0; i < array1.length; i++) {
      if (array1[i] != array2[i])
        return false;
    }

    return true;
  }

}

