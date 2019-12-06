package com.fulan.server.service.impl;

import com.fulan.server.dao.ExcelDao;
import com.fulan.server.model.WriteModel;
import com.fulan.server.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ExcelDao excelDao;
    @Override
    public void insert(List<WriteModel> writeModelList) {
        excelDao.insert(writeModelList);
    }
}
