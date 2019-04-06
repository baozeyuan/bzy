package com.fh.shop.admin.mapper.log;


import com.fh.shop.admin.po.log.Log;

import java.util.List;

public interface ILogMapper {
    void addLog(Log log);
    //获取总条数
    Long findLogCount(Log log);
    //分页条件查询日志信息
    List<Log> findLog(Log log);

}
