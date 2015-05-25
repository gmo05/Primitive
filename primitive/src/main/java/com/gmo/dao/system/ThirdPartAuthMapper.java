package com.gmo.dao.system;

import java.util.List;

import com.gmo.model.system.ThirdPartAuth;

public interface ThirdPartAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ThirdPartAuth record);

    int insertSelective(ThirdPartAuth record);

    ThirdPartAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ThirdPartAuth record);

    int updateByPrimaryKey(ThirdPartAuth record);
    
    List<ThirdPartAuth> getAll();
    
    ThirdPartAuth selectByDeviceId(String deviceId);
    
    
    /**
     * 周伟雄，待修
     * @param record
     * @return
     */
    long insertThirdPartLog(ThirdPartAuth record);
    
    void updateThirdPartLogById(ThirdPartAuth record);
}