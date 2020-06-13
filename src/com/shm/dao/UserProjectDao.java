package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shm.bean.Project;
import com.shm.bean.UserProject;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;



public class UserProjectDao {
	
	/**
	 * 通过userId获取UserProject
	 * @param userId
	 * @return
	 */
	public List<UserProject> get(int userId) {
    	List<UserProject> beans = new ArrayList<UserProject>();
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from userproject where uid = " + userId;
  
            ResultSet rs = s.executeQuery(sql);
  
            while (rs.next()) {
                UserProject bean = new UserProject();
                
                int id = rs.getInt("id");
                bean.setId(id);
                int pid = rs.getInt("pid");
                //System.out.println(pid);
                bean.setPid(pid);
                
                bean.setUid(userId);
                
                beans.add(bean);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
	
	public void add(UserProject bean) {
		
		String sql = "insert into userproject values(null ,? ,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setInt(1, bean.getUid());
			ps.setInt(2, bean.getPid());
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void delete(int pid) {
		  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from userproject where pid = " + pid;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    

}
