package org.circadia.generalizedOperations.screenrecording;

import org.circadia.generalizedOperations.constants.FrameworkStringConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.circadia.drivers.AndroidDriverManager.getDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenRecordingUtils {
  public static void startScreenRecording() {
    getDriver().startRecordingScreen();
  }
  public static void stopScreenRecording(String className, String methodName) {
    var recordedVideoFile = getDriver().stopRecordingScreen();
    var pathToWriteVideoFile = FrameworkStringConstants.getScreenRecordingsPath(className) + File.separator + methodName + ".mp4";
    writeToOutputStream(pathToWriteVideoFile, recordedVideoFile);
  }
  static void writeToOutputStream(String filePathToWrite, String recordedVideoFile) {
    try (FileOutputStream outputStream = new FileOutputStream(filePathToWrite)) {
      outputStream.write(Base64.decodeBase64(recordedVideoFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}