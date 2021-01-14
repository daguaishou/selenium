package Data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tool {
    //句柄
    private List<String> handles=new ArrayList<String>();
    protected WebDriver driver;
    //构造函数
    public Tool(WebDriver driver) {
        this.driver=driver;
    }
    //生成截图
    protected void screenshot(String str) throws IOException {
        //截图操作
        File screenShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //保存截图
        FileUtils.copyFile(screenShot,new File(String.format("target/Picture/%s.png",str)));
    }
    //获取新窗口的权柄
    protected WebDriver getHandle() throws InterruptedException {
        //首先得到最先的窗口 权柄
        handles.add(driver.getWindowHandle());
        //得到浏览器所有窗口的权柄为Set集合，遍历
        for(String winHandle : driver.getWindowHandles()) {
            int i=0;
            for(;i<handles.size();i++){
                //如果为 最先的窗口 权柄跳出
                if (winHandle.equals(handles.get(i))) {
                    break;
                }
            }
            if(i==handles.size()){
                //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
                return driver.switchTo().window(winHandle);
            }
        }
        return driver;
    }
    //根据输入值操控键盘
    protected void moveKey(WebElement element, int key){
        for(int i=1;i<key;i++){
            //光标向下移动
            element.sendKeys(Keys.ARROW_DOWN);
        }
        //键盘敲击enter
        element.sendKeys(Keys.ENTER);
    }
}
