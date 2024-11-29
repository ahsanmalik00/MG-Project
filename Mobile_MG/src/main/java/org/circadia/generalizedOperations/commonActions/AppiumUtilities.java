package org.circadia.generalizedOperations.commonActions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.connection.ConnectionState;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.github.cdimascio.dotenv.Dotenv;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;

import static org.circadia.drivers.AndroidDriverManager.getDriver;
import static org.circadia.generalizedOperations.constants.FrameworkPathConstants.ELEMENT_SCREENSHOT_DIR;
import static org.circadia.generalizedOperations.constants.FrameworkStringConstants.*;
import static org.circadia.generalizedOperations.constants.FrameworkTimeConstants.FIVE_THOUSAND_MILLI_SECOND_WAIT;
import static org.circadia.pageObjects.MGMobileAppPages.clinicalAlertsTabModule.ClinicalAlertsTabTestData.blackBackgroundColor;

public abstract class AppiumUtilities {
    public List < HashMap < String, String >> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<>() {
        });
    }

    public WebElement getElementBy(String strategy, String value) {
        return switch (strategy.toLowerCase()) {
            case "id" -> getDriver().findElement(AppiumBy.id(getIdentifiersGeneralPath() + value));
            case "xpath" -> getDriver().findElement(AppiumBy.xpath(value));
            case "classname" -> getDriver().findElement(AppiumBy.className(value));
            case "name" -> getDriver().findElement(AppiumBy.name(value));
            case "tagname" -> getDriver().findElement(AppiumBy.tagName(value));
            case "linktext" -> getDriver().findElement(AppiumBy.linkText(value));
            case "partiallinktext" -> getDriver().findElement(AppiumBy.partialLinkText(value));
            default ->
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
        };
    }

    public static List < WebElement > getListOfElementsBy(String strategy, String value) {
        return switch (strategy.toLowerCase()) {
            case "id" -> getDriver().findElements(AppiumBy.id(getIdentifiersGeneralPath() + value));
            case "xpath" -> getDriver().findElements(AppiumBy.xpath(value));
            case "classname" -> getDriver().findElements(AppiumBy.className(value));
            case "name" -> getDriver().findElements(AppiumBy.name(value));
            case "tagname" -> getDriver().findElements(AppiumBy.tagName(value));
            case "linktext" -> getDriver().findElements(AppiumBy.linkText(value));
            case "partiallinktext" -> getDriver().findElements(AppiumBy.partialLinkText(value));
            default ->
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
        };
    }

    public void setImplicitWait(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void setFreezeWait(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public static Dotenv loadDotenv(String filePath) {
        return Dotenv.configure()
                .directory(filePath)
                .load();
    }

    public void toggleWifiState(String wifiState) throws InterruptedException {
        ConnectionState connectionState = getDriver().getConnection();
        boolean wifiEnabled = connectionState.isWiFiEnabled();
        switch (wifiState) {
            case "On" -> {
                if (!wifiEnabled) {
                    getDriver().toggleWifi();
                    setFreezeWait(FIVE_THOUSAND_MILLI_SECOND_WAIT);
                }
            }
            case "Off" -> {
                if (wifiEnabled) {
                    getDriver().toggleWifi();
                }
            }
        }
    }

    public boolean checkBackgroundColor(String strategy, String identifier, String elementName, String colorHexValue) {
        WebElement element = getElementBy(strategy, identifier);
        createDirectory(ELEMENT_SCREENSHOT_DIR);
        String saveReadFile = ELEMENT_SCREENSHOT_DIR + File.separator + elementName + ".png";
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        File savedFile = new File(saveReadFile);

        try {
            FileUtils.copyFile(scrFile, savedFile);
            BufferedImage image = ImageIO.read(savedFile);

            int screenshotWidth = image.getWidth();
            int screenshotHeight = image.getHeight();

            int x = (int)(screenshotWidth * 0.2);
            int y = (int)(screenshotHeight * 0.8);

            System.out.println("Screenshot dimensions: " + screenshotWidth + "x" + screenshotHeight);
            System.out.println("Calculated coordinates: (" + x + ", " + y + ")");

            if (x >= 0 && x < screenshotWidth && y >= 0 && y < screenshotHeight) {
                int pixelColor = image.getRGB(x, y);
                int r = (pixelColor & 0x00ff0000) >> 16;
                int g = (pixelColor & 0x0000ff00) >> 8;
                int b = pixelColor & 0x000000ff;

                String hex = String.format("#%02x%02x%02x", r, g, b);
                System.out.println("Color Actual Hex Value: " + hex);
                return hex.equalsIgnoreCase(colorHexValue) || hex.equalsIgnoreCase(blackBackgroundColor);
            }
            else
            {
                System.out.println("Coordinates are out of bounds.");
            }
        } catch (IOException e) {
            System.out.println("Failed to read or save the screenshot file.");
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkElementIsAtBottomRight(String strategy, String identifier) {
        WebElement element = getElementBy(strategy, identifier);
        Point elementLocation = element.getLocation();
        Dimension elementSize = element.getSize();

        // Get the dimensions of the device screen
        Dimension screenSize = getDriver().manage().window().getSize();

        // Calculate the position on the screen
        int screenBottom = screenSize.getHeight();
        int screenRight = screenSize.getWidth();

        // Calculate the threshold values for being close to the bottom right
        int thresholdX = screenRight - (screenRight / 4); // 1/4 from the right
        int thresholdY = screenBottom - (screenBottom / 4); // 1/4 from the bottom

        // Check if the element is close to the bottom right
        return (elementLocation.getX() + elementSize.getWidth()) >= thresholdX &&
                (elementLocation.getY() + elementSize.getHeight()) >= thresholdY;
    }
    public Date convertTimeStringToDate(String pattern, String dateTime) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.parse(dateTime);
    }

    public String getCurrentTimeInString(String format, int hour) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, hour);
        Date today = calendar.getTime();
        return dateFormat.format(today);
    }

    public Date getCurrentTime(String format, int days) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        Date today = calendar.getTime();
        return dateFormat.parse(dateFormat.format(today));
    }

    public Date toDate(String format, String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        return dateFormat.parse(date);
    }

    public boolean isChronological(ArrayList < Date > dates) {
        if (dates.size() <= 1) return true;
        for (int i = 1; i < dates.size(); ++i) {
            // you can check with > operator if you want to test the reverse order
            if (dates.get(i).after(dates.get(i - 1))) return false;
        }
        return true;
    }
    public boolean isDateChronological(List<String> dateTimeList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        Date previousDate = null;
        for (String dateTimeString : dateTimeList) {
            try {
                Date currentDate = dateFormat.parse(dateTimeString);

                if (previousDate != null && currentDate.after(previousDate)) {
                    System.out.println("Current date: " + currentDate);
                    System.out.println("Previous date: " + previousDate);
                    return false; // Not in chronological order
                }
                previousDate = currentDate;
            } catch (ParseException e) {
                e.printStackTrace();
                return false; // Invalid date format
            }
        }
        return true; // In chronological order
    }

}