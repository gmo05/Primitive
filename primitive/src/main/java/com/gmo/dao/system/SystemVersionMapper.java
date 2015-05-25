package com.gmo.dao.system;

import com.gmo.model.system.SystemVersion;

public interface SystemVersionMapper {
    int insert(SystemVersion record);

    int insertSelective(SystemVersion record);
    
    String getLatestVersion();
}