package org.circadia.generalizedOperations.configloader;

import org.circadia.generalizedOperations.constants.FrameworkPathConstants;
import org.circadia.generalizedOperations.customexceptions.InvalidPathException;
import org.circadia.generalizedOperations.customexceptions.JsonFileUsageException;
import org.circadia.generalizedOperations.enums.ConfigJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtils {

  private static Map < String, String > map;

  public static String getValue(String key, String filePath) {
    try {
      return JsonPath.read(new File(filePath), key);
    } catch (IOException e) {
      throw new InvalidPathException("Can't read file, check the config.json");
    }
  }

  static void readJson(String jsonPath) {
    try {
      map = new ObjectMapper().readValue(new File(jsonPath),
              new TypeReference < HashMap < String, String >> () {});
    } catch (IOException e) {
      throw new JsonFileUsageException("IOException occurred while reading Json file in the specified path");
    }
  }

  public static String getConfig(ConfigJson key) {
    readJson(FrameworkPathConstants.CONFIG_JSON_PATH);
    if (Objects.isNull(map.get(key.name().toLowerCase()))) {
      throw new JsonFileUsageException("Property name - " + key + " is not found. Please check the config.json");
    }
    return map.get(key.name().toLowerCase());
  }
}