import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IsinOlsunRemoteDeviceTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung_Galaxy_S6_sjc_free");
        //caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        //caps.setCapability("platformName", "Android");
        //caps.setCapability("platformVersion", "7.0");
        //caps.setCapability("skipUnlock","true");
        //caps.setCapability("appPackage", "com.isinolsun.app");
        //caps.setCapability("appActivity","com.isinolsun.app.activities.SplashActivity");
        caps.setCapability("noReset","false");
        caps.setCapability("testobject_api_key","44F4A04DB8344B76BA3C45BCC1D8FD8B");
        caps.setCapability("testobject_app_id","1");
        caps.setCapability("testobject_suite_name","isinolsunTestSuite");
        caps.setCapability("testobject_test_name","isinolsunTest1");
        caps.setCapability("testobject_session_creation_timeout","900000");
        caps.setCapability("cacheId","1663dc2b323");
        caps.setCapability("appiumVersion","1.9.1");


        driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void basicTest () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/animation_view"))).click();

        //Click and pass Tutorial
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/btn_skip"))).click();

        //Click to "Is Ariyorum" Button
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();


        //Notification Allow
        if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size()>0) {
            driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
        }

        //Click second job
        /*wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(secondNewJob))).click();*/

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
