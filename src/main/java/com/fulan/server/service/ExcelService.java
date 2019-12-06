package com.fulan.server.service;

import com.fulan.server.model.WriteModel;

import java.util.List;

public interface ExcelService {
    void insert(List<WriteModel> writeModelList);
}
