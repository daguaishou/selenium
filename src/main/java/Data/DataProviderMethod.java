package Data;

import Tool.ReadExcel;
import org.testng.annotations.DataProvider;

public class DataProviderMethod {
    @DataProvider(name = "DataExcel")
    public Object[][] DataExcel() {
        Object[] objects = new Object[1];
        ReadExcel read=new ReadExcel();
        return new Object[][]{
                {read.read()}
        };
    }
}
