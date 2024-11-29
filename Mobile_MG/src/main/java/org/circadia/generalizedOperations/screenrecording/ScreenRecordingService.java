package org.circadia.generalizedOperations.screenrecording;

import org.circadia.generalizedOperations.enums.ConfigProperties;
import org.circadia.generalizedOperations.configloader.PropertyUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenRecordingService {

  public static void startRecording() {
    if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
      ScreenRecordingUtils.startScreenRecording();
    }
  }

  public static void stopRecording(String className, String methodName) {
    if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
      ScreenRecordingUtils.stopScreenRecording(className, methodName);
    }

  }
}