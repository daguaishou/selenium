package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Browser {
    public WebDriver getDriver(String browser,String browserAdd,String url) throws InterruptedException {
        WebDriver driver = null;
        if(browser.equals("chrome")){
            browser="webdriver.chrome.driver";
            //加载驱动
            System.setProperty(browser,browserAdd);
            //获取的浏览器驱动
            driver = new ChromeDriver();
        }else if (browser.equals("fireFox")){
            browser="webdriver.gecko.driver";
            //加载驱动
            System.setProperty(browser,browserAdd);
            //获取的浏览器驱动
            driver = new FirefoxDriver();
        }else if(browser.equals("")){
            Assert.assertEquals(driver,"@#@!");
        }
        //打开网址
        driver.get(url);
        //休眠两秒
        Thread.sleep(2000);
        //最大化窗口
        driver.manage().window().maximize();
        //返回driver
        return driver;
    }
}
