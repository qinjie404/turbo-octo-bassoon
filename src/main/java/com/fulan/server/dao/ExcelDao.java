package com.fulan.server.dao;

import com.fulan.server.model.WriteModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelDao {
    void insert(List<WriteModel> writeModelList);
}
