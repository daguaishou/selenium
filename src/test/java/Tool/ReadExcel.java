package Tool;


import Data.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private Excel excel = new Excel();
    private User user;
    private Address address;
    private Pay pay;
    private Goods goods;


//    //读取。xls文件
//    public void getExcel() {
//        try {
//            jxl.Workbook wb = null;
//            InputStream is = new FileInputStream("E:\\AutoTest\\src\\001.xlsx");
//            wb = Workbook.getWorkbook(is);
//            Sheet sheet = wb.getSheet(0);
//            int row_total = sheet.getRows();
//            for (int j = 1; j < row_total; j++) {
//                Cell[] cells = sheet.getRow(j);
//                Browser browser = new Browser();
//                browser.getDriver(cells[0].getContents(), cells[1].getContents(), cells[2].getContents());
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    //读取.xlsx文件
    public Excel read() {
        List<User> userList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        List<Pay> payList = new ArrayList<>();
        //创建文件
        File excelFile = new File("E:\\AutoTest\\src\\001.xlsx");
        //创建XSSFWorkbook对象
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取页码数
        int numberOfSheets = wb.getNumberOfSheets();
        System.out.println("页数：" + numberOfSheets);
        //遍历页码
        for (int x = 0; x < numberOfSheets; x++) {
            //获取当前页码的内容
            XSSFSheet sheet = wb.getSheetAt(x);
            //打印有多少列
//            System.out.println(sheet.getRow(0).getPhysicalNumberOfCells());
            //获取总行数
            int rownum = sheet.getPhysicalNumberOfRows();
//            System.out.println(sheet.getSheetName() + "  " + rownum);
            if (rownum == 1) {
                continue;
            }
            //获取第二行的列数
            int column = sheet.getRow(1).getPhysicalNumberOfCells();
            //遍历行
            for (int i = 1; i < rownum; i++) {
                Row row = sheet.getRow(i);
                //遍历列
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    //获取表头名
                    Cell cellf = sheet.getRow(0).getCell(j);
                    //获取列
                    Cell cell = row.getCell(j);
                    String str = cellf.toString();
                    //判断表头
                    if (str.equals("浏览器")) {
                        excel.setBorwser(cell.toString());
                    } else if (str.equals("浏览器驱动地址")) {
                        excel.setBorwserAdd(cell.toString());
                        excel.setBorwserUrl("http://40.73.38.139:9910/");
                    } else if (str.equals("网址")) {
                        excel.setBorwserUrl(cell.toString());
                    } else if (str.equals("账号")) {
                        user = new User();
                        user.setName(cell.toString());
                    } else if (str.equals("密码")) {
                        user.setPass(cell.toString());
                    } else if (str.equals("是否滑动滚动条")) {
                        user.setScrollbar(Boolean.valueOf(cell.toString()));
                    } else if (str.equals("省")) {
                        address = new Address();
                        address.setProvince(cell.toString());
                    } else if (str.equals("市")) {
                        address.setCity(cell.toString());
                    } else if (str.equals("区")) {
                        address.setArea(cell.toString());
                    } else if (str.equals("详细地址")) {
                        address.setDetaaddress(cell.toString());
                    } else if (str.equals("付款方式")) {
                        if (row.getPhysicalNumberOfCells() != 0) {
                            pay = new Pay();
                            pay.setBusinessform(cell.toString());
                        }
                    } else if (str.equals("付款方式")) {
                        pay.setPayWayRadio(cell.toString());
                    } else if (str.equals("业务形式")) {
                        pay.setPayWay(cell.toString());
                    } else if (str.equals("零库存")) {
                        pay.setZeroStock(Boolean.valueOf(cell.toString()));
                    } else if (str.equals("合同签订预付")) {
                        pay.setPrePay(Float.valueOf(cell.toString()));
                    } else if (str.equals("合同预付下拉框")) {
                        pay.setPrePayframe(cell.toString());
                    } else if (str.equals("付款前下拉框")) {
                        pay.setDelivergoods(cell.toString());
                    } else if (str.equals("付款")) {
                        pay.setPayment1(Float.valueOf(cell.toString()));
                    } else if (str.equals("验收")) {
                        pay.setReceivinggoods(cell.toString());
                    } else if (str.equals("月份")) {
                        pay.setMonth(cell.toString());
                    } else if (str.equals("付款")) {
                        pay.setPayment2(Float.valueOf(cell.toString()));
                    } else if (str.equals("质保期")) {
                        pay.setWarrantyPeriod(Integer.valueOf(cell.toString()));
                    } else if (str.equals("质保金")) {
                        pay.setPremium(Float.valueOf(cell.toString()));
                    } else if (str.equals("补充说明")) {
                        if (!cell.toString().equals(null)) {
                            pay.setPayExplain(cell.toString());
                        }
                    } else if (str.equals("商品名称")) {
                        goods = new Goods();
                        goods.setGoodsName(cell.toString());
                    } else if (str.equals("供应商名称")) {
                        if (!cell.toString().equals(null)) {
                            goods.setConmpanyName(cell.toString());
                        }
                    } else if (str.equals("规格型号")) {
                        if (!cell.toString().equals(null)) {
                            goods.setModel(cell.toString());
                        }
                    }
                }
                if (sheet.getSheetName().equals("用户")) {
                    excel.setUser(user);
                }
                if (sheet.getSheetName().equals("交货地址")) {
                    excel.setDeliveryAdd(address);
                }
                if (sheet.getSheetName().equals("付款方式")) {
                    excel.setPay(pay);
                }
                if (sheet.getSheetName().equals("搜索商品")) {
                    excel.setGoods(goods);

                }
            }
        }
        System.out.println(user.toString());
        return excel;
    }
}
