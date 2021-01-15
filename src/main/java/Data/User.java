package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class User {
    //用户名
    private String name;
    //密码
    private String pass;
    //是否滑动滚动条
    private boolean scrollbar;
    //浏览器驱动
    private WebDriver driver;
    private Tool tool;
    //是否登录成功
    private boolean isLogin = false;
    //前一个动作
    private String preActive = "";

    public User() {

    }

    //获取driver
    public WebDriver getDriver() {
        return driver;
    }

    //设置driver
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //是否欢动滚动条
    public boolean isScrollbar() {
        return scrollbar;
    }

    //获取用户名
    public String getName() {
        return name;
    }

    //获取密码
    public String getPass() {
        return pass;
    }

    //设置用户名
    public void setName(String name) {
        this.name = name;
    }

    //设置密码
    public void setPass(String pass) {
        this.pass = pass;
    }

    //设置是否滑动滚动条
    public void setScrollbar(boolean scrollbar) {
        this.scrollbar = scrollbar;
    }

    //构造函数
    public User(WebDriver driver, String name, String pass, boolean scrollbar) {
        this.driver = driver;
        this.name = name;
        this.pass = pass;
        this.scrollbar = scrollbar;
        tool = new Tool(driver);
    }

    //登录
    public void load() throws InterruptedException, IOException {
        if (!preActive.equals("Quit")) {
            //点击“请登录”
            //*[@id="publicTop-publicTop-V27Xd"]/div/div/a[1]
            driver.findElement(By.xpath("//*[@id=\"publicTop-publicTop-V27Xd\"]/div/div/a[1]")).click();
            //休眠1秒
            Thread.sleep(3000);
            //点击密码登录
            //driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[1]/div/div/div/div/div[1]/div[2]\n")).click();
            //输入手机号
            driver.findElement(By.id("mobile")).sendKeys(this.name);
            Thread.sleep(3000);
            //输入密码
            driver.findElement(By.id("password")).sendKeys(this.pass);
            Thread.sleep(3000);
            if (scrollbar) {
                //获取滑动元素
                //*[@id="main"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[4]/div/div/span/div/div/div[1]
                WebElement element1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[4]/div/div/span/div/div/div[1]"));
                //*[@id="main"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[4]/div/div/span/div/div/div[3]
                //WebElement element2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[4]/div/div/span/div/div/div[3]"));
                //创建动作
                Actions act = new Actions(driver);
                //滑动滚动条
                act.dragAndDropBy(element1, 238, 0).perform();
              //  act.dragAndDropBy(element2, 238, 0).perform();
            }
            Thread.sleep(2000);
            //点击登录
            //*[@id="main"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[5]/div/div/span/button
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/div/form/div/div[3]/div[2]/div[5]/div/div/span/button")).click();
            //是否登录成功
            WebElement element = new WebDriverWait(driver, 5, 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/span")));
            if (element.getText().equals("登录成功")) {
                tool.screenshot(element.getText());
                isLogin = true;
            } else {
                tool.screenshot(element.getText());
                System.out.println("登录失败");
                //判断是否登录成功
                Assert.assertEquals(element.getText(), "登录成功");
            }
            preActive = "Login";
        }
        Thread.sleep(3000);
    }

    //加入进货单
    public void Incar() throws IOException, InterruptedException {
        //判断前一个动作是否为退出登录
        if (!preActive.equals("Quit")) {
            //判断登录是否成功
            if (isLogin) {
                //判断前一步操作是什么
                if (preActive.equals("Searchgoods")) {
                    //搜索商品后进入进货单
                    driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[7]/div[1]/a[1]/div")).click();
                } else {
                    //直接进入进货单//*[@id="main"]/div/div[2]/a[1]/div
                    driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/a[1]/div")).click();
                }
                driver = tool.getHandle();
                tool.screenshot("进入进货单");
            } else {

                tool.screenshot("请登录");
            }
            preActive = "Incar";
        }
        Thread.sleep(3000);
    }

    //根据商品名和供应商名搜索商品
    public void searchGoods(String sname, String cname) throws InterruptedException, IOException {
        if (!preActive.equals("Quit")) {
            if (preActive.equals("Login") && !isLogin) {
                driver.findElement(By.linkText("返回首页 >")).click();
                Thread.sleep(2000);
            }
            //设置退出标识
            boolean isSignout = false;
            //点击"找商品"
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]")).click();
            //休眠2秒
            Thread.sleep(2000);
            //点击输入框
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[2]/div/input")).sendKeys(sname);
            //搜索商品
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[2]/button")).click();
            //休眠2秒
            Thread.sleep(2000);
            //获取页码的list
            java.util.List<WebElement> plist = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li"));
            if (plist.size() > 0) {
                //获取页码数
                int page = Integer.parseInt(driver.findElement(By.xpath(String.format("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li[%d]", plist.size() - 2))).getText());
                //打印页码数
                //System.out.println(driver.findElement(By.xpath(String.format("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li[%d]",plist.size()-2))).getText());

                //在页面找到相应的商品
                for (int i = 0; i < page; i++) {
                    //获取页面商品数
                    List<WebElement> glist = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[5]/div[1]/div"));
                    for (int j = 0; j < glist.size(); j++) {
                        //拼接路径
                        String str = String.format("//*[@id=\"main\"]/div/div[5]/div[1]/div[%d]", j + 1);
                        //System.out.println(str);
                        //判断是否是找到的商品
                        if (driver.findElement(By.xpath(str + "/div/div[5]/a")).getText().equals(cname)
                                && driver.findElement(By.xpath(str + "/div/div[3]/a/div")).getText().equals(sname)) {
                            tool.screenshot("搜索成功");
                            //找到相应的商品加入进货单
                            driver.findElement(By.xpath(str + "/div/button")).click();
                            //将退出标识设置成true
                            isSignout = true;
                            break;
                        }
                    }
                    //判断是否退出循环
                    if (isSignout) {
                        break;
                    }
                    //判断是否为最后一页
                    if (i < page - 1) {
                        //点击第i+2页
                        driver.findElement(By.linkText(String.valueOf(i + 2))).click();
                        //休眠3秒
                        Thread.sleep(2000);
                    } else {
                        System.out.println("没有查找的商品1111");
                        tool.screenshot("没有找到");
                    }
                }
            } else {
                tool.screenshot("没有找到");
            }
            preActive = "Searchgoods";
        }
        Thread.sleep(3000);
    }

    //根据商品名搜索商品
    public void searchGoods(String sname) throws InterruptedException, IOException {
        if (!preActive.equals("Quit")) {
            if (preActive.equals("Login") && !isLogin) {
                driver.findElement(By.linkText("返回首页 >")).click();
                Thread.sleep(2000);
            }
            boolean isFand = false;
            //点击"找商品"
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]")).click();
            //休眠2秒
            Thread.sleep(2000);
            //点击输入框
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[2]/div/input")).sendKeys(sname);
            //搜索商品
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/div[1]/div[1]/div[2]/button")).click();
            //休眠2秒
            Thread.sleep(2000);
            //获取页码的list
            java.util.List<WebElement> plist = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li"));
            if (plist.size() > 0) {
                //获取页码数
                int page = Integer.parseInt(driver.findElement(By.xpath(String.format("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li[%d]", plist.size() - 2))).getText());
                //打印页码数
                //System.out.println(driver.findElement(By.xpath(String.format("//*[@id=\"main\"]/div/div[5]/div[2]/div/ul/li[%d]",plist.size()-2))).getText());
                //在页面找到相应的商品
                for (int i = 0; i < page; i++) {
                    //获取当前页面商品数
                    List<WebElement> glist = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[5]/div[1]/div"));
                    System.out.println(glist.size());
                    for (int j = 0; j < glist.size(); j++) {
                        //拼接路径
                        String str = String.format("//*[@id=\"main\"]/div/div[5]/div[1]/div[%d]", j + 1);
                        //System.out.println(str);
                        //判断是否是找到的商品
                        if (driver.findElement(By.xpath(str + "/div/div[3]/a/div")).getText().equals(sname)) {
                            //找到相应的商品加入进货单
                            driver.findElement(By.xpath(str + "/div/div[7]/button[1]")).click();
                            isFand = true;
                            Thread.sleep(1500);
                            continue;
                        }
                    }
                    //判断是否为最后一页
                    if (i < page - 1) {
                        //点击第i+2页
                        driver.findElement(By.linkText(String.valueOf(i + 2))).click();
                        //休眠3秒
                        Thread.sleep(3000);
                    } else if (i == page - 1 && !isFand) {
                        System.out.println("没有查找的商品222");
                        tool.screenshot("没有找到");
                    }
                }
                preActive = "Searchgoods";
            }
        } else {
            tool.screenshot("没有找到");
        }
        Thread.sleep(3000);
    }
    //退出登录
    public void loginOut() throws InterruptedException, IOException {
        //判断前一个动作是否是关闭浏览器
        if(!preActive.equals("Quit") && isLogin) {
            //点击退出登录
            driver.findElement(By.xpath("//*[@id=\"publicTop-publicTop-V27Xd\"]/div/div/span[3]")).click();
            Thread.sleep(1000);
            //点击确定
            try {
                driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[2]/button[2]")).click();
            } catch (Exception e) {
                driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[2]/button[2]")).click();
            }
            WebElement element = new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/span/div/div/div/span")));
            tool.screenshot(element.getText());
            System.out.println("退出成功");
            preActive = "LoginOut";
        }
        //休眠3秒
        Thread.sleep(3000);
    }
}
