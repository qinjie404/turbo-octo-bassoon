package com.fulan.server.service.impl;

import com.fulan.server.dao.LoggerDao;
import com.fulan.server.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 13862
 */
@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    private LoggerDao loggerDao;

}
