package com.fh.shop.admin.biz.log;


import com.fh.shop.admin.mapper.log.ILogMapper;
import com.fh.shop.admin.po.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public class LogServiceImpl implements ILogService {
    //注入dao层
    @Autowired
    private ILogMapper logDao;
    /**
     * 添加日志
     * @param log
     */
    @Override
    public void addLog(Log log) {
        logDao.addLog(log);
    }


    /**
     * 获取总条数
     * @param log
     * @return
     */
    @Override
    public Long findLogCount(Log log) {
        Long totalCount= logDao.findLogCount(log);
        return totalCount;
    }

    /**
     * 分页条件查询日志信息
     * @param log
     * @return
     */
    @Override
    public List<Log> findLog(Log log) {
        List<Log> logList=logDao.findLog(log);
        return logList;
    }
}
