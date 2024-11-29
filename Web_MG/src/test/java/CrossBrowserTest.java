//////import io.github.bonigarcia.wdm.WebDriverManager;
//////import org.openqa.selenium.By;
//////import org.openqa.selenium.Keys;
//////import org.openqa.selenium.WebDriver;
//////import org.openqa.selenium.WebElement;
//////import org.openqa.selenium.chrome.ChromeDriver;
//////import org.openqa.selenium.firefox.FirefoxDriver;
//////import org.openqa.selenium.interactions.Actions;
//////import org.testng.annotations.*;
//////
//////import static org.MG.Utilities.Utility.scrollToElement;
//////
//////public class CrossBrowserTest {
//////    WebDriver driver;
//////
//////
//////    @Parameters("browser")
//////    @BeforeTest
//////    public void setUpDriver(String browser) {
//////        // Initialize the WebDriver based on the browser parameter
//////        if (browser.equalsIgnoreCase("chrome")) {
//////            WebDriverManager.chromedriver().setup();
//////            driver = new ChromeDriver();
//////        } else if (browser.equalsIgnoreCase("firefox")) {
//////            WebDriverManager.firefoxdriver().setup();
//////            driver = new FirefoxDriver();
//////        }
//////
//////        driver.get("https://demoqa.com/automation-practice-form/");
//////    }
//////
//////
//////    @Test
//////    public void testPageTitle() throws InterruptedException {
//////        WebElement firstName = driver.findElement(By.id("firstName"));
//////        scrollToElement(firstName);
//////        firstName.sendKeys("Umair");
//////
//////        WebElement lastName = driver.findElement(By.id("lastName"));
//////        scrollToElement(lastName);
//////        lastName.sendKeys("Khan");
//////
//////        WebElement userEmail = driver.findElement(By.id("userEmail"));
//////        scrollToElement(userEmail);
//////        userEmail.sendKeys("abcd@gmail.com");
//////
//////        WebElement genderMale = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
//////        scrollToElement(genderMale);
//////        genderMale.click();
//////
//////        WebElement userNumber = driver.findElement(By.id("userNumber"));
//////        scrollToElement(userNumber);
//////        userNumber.sendKeys("03002677522");
//////
//////        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
//////        scrollToElement(dobInput);
//////        dobInput.sendKeys("07 Oct 2024");
//////        dobInput.sendKeys(Keys.ENTER);
//////
//////        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
//////        scrollToElement(subjectsInput);
//////        subjectsInput.sendKeys("math");
//////        subjectsInput.sendKeys(Keys.ENTER);
//////
//////        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
//////        scrollToElement(hobbiesCheckbox);
//////        Thread.sleep(1000);
//////        hobbiesCheckbox.click();
//////
//////        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
//////        Thread.sleep(2000);
//////        uploadPicture.sendKeys("C:\\Users\\Ahsan\\Downloads\\MG\\src\\test\\resources\\WIN_20241011_15_07_37_Pro.jpg");
//////
//////        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
//////        scrollToElement(currentAddress);
//////        currentAddress.sendKeys("xyz Karachi");
//////
//////        WebElement stateDropdown = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
//////        scrollToElement(stateDropdown);
//////        stateDropdown.click();
//////        Thread.sleep(1000);
//////        Actions actions = new Actions(driver);
//////        actions.sendKeys(Keys.SPACE).perform();
//////
//////        WebElement cityDropdown = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));
//////        scrollToElement(cityDropdown);
//////        cityDropdown.click();
//////        Thread.sleep(1000);
//////        actions.sendKeys(Keys.SPACE).perform();
//////
//////        WebElement submitButton = driver.findElement(By.id("submit"));
//////        scrollToElement(submitButton);
//////        Thread.sleep(1000);
//////        submitButton.sendKeys(Keys.ENTER);
//////    }
//////
//////    @AfterTest
//////    public void tearDown() {
//////
//////    }
//////}
////
////
////
////
////
////
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class CrossBrowserTest {
//    WebDriver driver;
//
//    @BeforeTest
//    @Parameters("browser")
//    public void setUp(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
////            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
////            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
//            driver = new FirefoxDriver();
//        }
//    }
//
//    @Test
//    public void testPageTitle() {
//        driver.get("https://demoqa.com/automation-practice-form/");
//        String pageTitle = driver.getTitle();
//        System.out.println("Page title is: " + pageTitle);
//
//    }
//
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
//}
//
