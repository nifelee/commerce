package com.nifelee.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JsonUtils {

  public static String toString(Object obj) {
    ObjectMapper mapper = new ObjectMapper();
    String result;
    try {
      result = mapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(String.format("convert to json string error..,%s", e.toString()), e);
    }
    return result;
  }

  public static <T> T toObject(String str, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    T result;
    try {
      result = mapper.readValue(str, clazz);
    } catch (Exception e) {
      throw new RuntimeException(String.format("convert to object error..,%s", e.toString()), e);
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  public static List<String> diff(String expected, String actual, String... ignoreKeyNames) {
    ObjectMapper mapper = new ObjectMapper();
    List<String> result = new ArrayList<>();
    try {
      Map<String, Object> expectedMap = (Map<String, Object>) mapper.readValue(expected, Map.class);
      Map<String, Object> actualMap = (Map<String, Object>) mapper.readValue(actual, Map.class);

      for (Map.Entry<String, Object> entry : expectedMap.entrySet()) {
        String key = entry.getKey();
        if (!ArrayUtils.contains(ignoreKeyNames, key) && !actualMap.containsKey(key)) {
          result.add(key);
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(String.format("json compare fails..,%s", e.toString()), e);
    }
    return result;
  }

  public static boolean equals(String expected, String actual, String... ignoreKeyNames) {
    return diff(expected, actual, ignoreKeyNames).size() == 0;
  }

}

