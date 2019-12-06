package com.fulan.server.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fulan.server.model.WriteModel;
import com.fulan.server.service.ExcelService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13862
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener<WriteModel> {
    private static final Integer MAX_SIZE = 50;
    private List<WriteModel> data = new ArrayList<>();
    private static int count = 0;

    @Override
    public void invoke(WriteModel writeModel, AnalysisContext context) {
        /*log.info("当前行："+context.getCurrentRowNum());
        log.info("当前数据："+object.toString());*/
        data.add(writeModel);
        count++;
        if (count >= MAX_SIZE) {
            insert(data);
        }

    }

    private void insert(List<WriteModel> writeModelList) {
        ExcelService excelService = SpringJobBeanFactory.getBean(ExcelService.class);
        excelService.insert(writeModelList);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        data.clear();
    }
}
