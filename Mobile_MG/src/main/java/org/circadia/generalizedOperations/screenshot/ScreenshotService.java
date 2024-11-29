package org.circadia.generalizedOperations.screenshot;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotService {

  // Abstract layer to handle the change in business requirement
  public static String getScreenshotAsBase64() {
    return ScreenshotUtils.captureScreenshotAsBase64();
  }
  public static String getScreenshotAsFile(String testName) throws IOException {
    return ScreenshotUtils.captureScreenshotAsFile(testName);
  }
}