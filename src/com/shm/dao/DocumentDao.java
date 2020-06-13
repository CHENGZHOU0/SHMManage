package com.shm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shm.bean.Document;
import com.shm.bean.Sensor;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;

public class DocumentDao {
	public List<Document> get(int pid) {
    	List<Document> beans = new ArrayList<Document>();
    	String sql = "select * from file where pid = " + pid;
  
    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
    		
            ResultSet rs = s.executeQuery(sql);
  
            while (rs.next()) {
                Document bean = new Document();
                
                int id = rs.getInt(1);
                bean.setId(id);
                String name = rs.getString("name");
                bean.setName(name);
                Date time = DateUtil.t2d(rs.getDate("time"));
                bean.setTime(time);
                String path = rs.getString("path");
                bean.setPath(path);
                bean.setPid(pid);
                beans.add(bean);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
	
	public void add(Document bean) {
		String sql = "insert into file values(null ,? ,?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setString(1, bean.getName());
			ps.setDate(2, DateUtil.d2t(bean.getTime()));
			ps.setString(3, bean.getPath());
			
			ps.setInt(4, bean.getPid());
			
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
	
	public void delete(int id) {
		  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from file where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
	
	public Document achieve(int id) {
		Document bean = null;
  
    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
    		  
            String sql = "select * from file where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                bean = new Document();
                
                String name = rs.getString("name");
                bean.setName(name);
                Date time = DateUtil.t2d(rs.getDate("time"));
                bean.setTime(time);
                String path = rs.getString("path");
                bean.setPath(path);
                int pid = rs.getInt("pid");
                bean.setPid(pid);
                
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
}
