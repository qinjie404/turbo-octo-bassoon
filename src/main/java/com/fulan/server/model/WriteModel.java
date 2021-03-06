package com.fulan.server.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriteModel extends BaseRowModel {
    @ExcelProperty(value = "ID",index = 0)
    private String id;
    @ExcelProperty(value = "姓名",index = 1)
    private String name;
    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;


}
