package com.fulan.server;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.*;
import com.fulan.server.listener.ExcelListener;
import com.fulan.server.model.WriteModel;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcelTest {

    /**
     * 简单模板excel
     *
     * @throws IOException
     */
    @Test
    public void writeExcel_1() throws IOException {

        String filePath = "F:" + File.separator + "easyexcel" + File.separator;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //文件输出位置
        OutputStream os = new FileOutputStream(filePath + "test1.xlsx");
        ExcelWriter ew = EasyExcelFactory.getWriter(os);
        //以WriteModel.class为模板生成表头
        Sheet sheet = new Sheet(1, 0, WriteModel.class);
        //第一个sheet的名字
        sheet.setSheetName("第一个sheet");
        ew.write(createModelList(), sheet);
        ew.finish();
        os.close();
    }


    /**
     * 解析excel
     */
    @Test
    public void parseExcel() {
        InputStream in = null;
        try {
            String filePath = "F:" + File.separator + "easyexcel" + File.separator + "test1.xlsx";
            File file = new File(filePath);
            in = new BufferedInputStream(new FileInputStream(file));
            //读取07版的excel
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(in, new Sheet(1, 1,WriteModel.class), excelListener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 自定义表头
     *
     * @throws IOException
     */
    @Test
    public void writeExcel_2() throws IOException {
        String filePath = "F:" + File.separator + "easyexcel" + File.separator;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //文件最终写入位置
        OutputStream os = new FileOutputStream(filePath + "test2.xlsx");
        ExcelWriter ew = EasyExcelFactory.getWriter(os);
        //创建一个sheet页
        Sheet sheet = new Sheet(1, 0);
        //设置sheet页的名字
        sheet.setSheetName("第一个sheet");
        //创建一个表格
        Table table = new Table(1);
        //设置表头
        table.setHead(createTestListHead());
        //设置表格样式
        table.setTableStyle(createTableStyle());
        //写数据
        ew.write1(createDynamicModelList(), sheet, table);
        //将上下文中的最终OutputStream写入到指定文件中
        ew.finish();
        //关闭流
        os.close();
    }

    private TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        Font headFont = new Font();
        //是否加粗
        headFont.setBold(true);
        //字体大小
        headFont.setFontHeightInPoints((short) 12);
        //字体样式
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        tableStyle.setTableHeadBackGroundColor(IndexedColors.LIGHT_YELLOW);
        Font contentFont = new Font();
        contentFont.setBold(false);
        contentFont.setFontHeightInPoints((short) 10);
        contentFont.setFontName("宋体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.PINK);
        return tableStyle;
    }

    private List<List<Object>> createDynamicModelList() {
        //所有行数据
        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            //一行数据
            List<Object> objects = new ArrayList<>();
            objects.add("姓名" + i);
            objects.add(Integer.valueOf(50 + i));
            objects.add(Integer.valueOf(49 + i));
            objects.add("班级" + i);
            rows.add(objects);
        }
        return rows;
    }

    private List<List<String>> createTestListHead() {
        //所有表头
        List<List<String>> head = new ArrayList<>();
        //第一列表头
        List<String> headColumn0 = new ArrayList<>();
        //第二列表头
        List<String> headColumn1 = new ArrayList<>();
        //第三列表头
        List<String> headColumn2 = new ArrayList<>();
        //第四列表头
        List<String> headColumn3 = new ArrayList<>();
        headColumn0.add("姓名");
        headColumn0.add("姓名");
        headColumn1.add("成绩");
        headColumn1.add("数学");
        headColumn2.add("成绩");
        headColumn2.add("英语");
        headColumn3.add("班级");
        headColumn3.add("班级");
        head.add(headColumn0);
        head.add(headColumn1);
        head.add(headColumn2);
        head.add(headColumn3);
        return head;
    }

    private List<? extends BaseRowModel> createModelList() {
        List<WriteModel> writeModelList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            WriteModel writeModel = WriteModel.builder().id(i+"").name("姓名" + i).age(i + 1).build();
            writeModelList.add(writeModel);
        }
        return writeModelList;
    }
}
