package com.fulan.server.dao;

import com.fulan.server.model.LoggerEntity;
import org.springframework.stereotype.Repository;

/**
 * @author 13862
 */
@Repository
public interface LoggerDao {
    void addLoggerInfo(LoggerEntity loggerEntity);
}
