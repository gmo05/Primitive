package com.gmo.base;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
//import com.gmo.core.commons.Page;

@Repository(value="baseDao")
public class BaseDao extends SqlSessionDaoSupport {
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
    public boolean delete(String deleteId,Integer id) {  
        try {
        	 getSqlSession().delete(deleteId, id);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;  
    }  
 
    public List getAll(String selectId) {  
        List list = null;  
        try {
            list = getSqlSession().selectList(selectId);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return list;  
    }  
 
    public boolean insert(String insertId, Object object) {  
        try {  
        	getSqlSession().insert(insertId, object);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;  
    }  
 
    public boolean update(String updateId, Object obj) {  
        try {  
        	getSqlSession().update(updateId, obj);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;  
    }

	public Object getById(String selectId, Object object) {
		return getSqlSession().selectOne(selectId, object);
	}

	public Object getById(String selectId, Integer id) {
		return getSqlSession().selectOne(selectId, id);
	}

	public int countAll(String selectId) {
		return getSqlSession().selectOne(selectId);
	}
	
	/**
	 * 修改外键约束
	 * @param status
	 */
	public void updateForeignKeyChecks(Integer status){
		try {  
        	getSqlSession().update("updateForeignKeyChecks", status);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
		
}
