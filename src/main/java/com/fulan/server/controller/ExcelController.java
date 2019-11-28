package com.fulan.server.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.fulan.server.model.WriteModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("/downLoad")
    public void excelDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = new String(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).getBytes(), "utf-8");
        Sheet sheet = new Sheet(1, 0, WriteModel.class);
        //第一个sheet的名字
        sheet.setSheetName("第一个sheet");
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        writer.write(createModelList(), sheet);
        writer.finish();
        out.close();
    }

    private List<? extends BaseRowModel> createModelList() {
        List<WriteModel> writeModelList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            WriteModel writeModel = WriteModel.builder().name("姓名" + i).password("密码" + i).age(i + 1).build();
            writeModelList.add(writeModel);
        }
        return writeModelList;
    }
}
