package Tool;

import Data.Browser;
import Data.Excel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class OpenBrowser {
    private WebDriver driver;
    private User user;
    private Excel excel;

    //打开网址
    @Test(dataProvider = "DataExcel", dataProviderClass = Data.DataProviderMethod.class)
    public void openUrl(Excel excel) throws InterruptedException {
        this.excel = excel;
        //创建Browser对象
        Browser browser = new Browser();
        driver = browser.getDriver(excel.getBorwser(), excel.getBorwserAdd(), excel.getBorwserUrl());
    }

    //登录
    @Test(dependsOnMethods = {"openUrl"})
    public void load() throws IOException, InterruptedException {
        user = new User(driver, excel.getUser().getName(), excel.getUser().getPass(), excel.getUser().isScrollbar());
        //登录
        user.load();

    }
    //搜索商品
    @Test(dependsOnMethods = "load")
    private void searchGoods() throws IOException, InterruptedException {
        user.searchGoods(excel.getGoods().getGoodsName());

    }    //进入进货单

    @Test(dependsOnMethods = "load")
    public void Incar() throws IOException, InterruptedException {
        user.Incar();
    }

    //退出登录
    @Test(dependsOnMethods = "load")
    public void loginOut() throws IOException, InterruptedException {
        user.loginOut();
    }
}
