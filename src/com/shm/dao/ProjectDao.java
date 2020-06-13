package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.shm.bean.Project;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;

public class ProjectDao {
	
	/**
	 * 统计数量
	 * @return
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			
			String sql = "select count(*) from project";
			
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return total;
	}
	
	/**
	 * 增
	 * @param bean
	 */
	public int add(Project bean) {
		int id = 0;
		String sql = "insert into project values(null ,? ,?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getAddress());
			ps.setDate(3, DateUtil.d2t(DateUtil.str2u(bean.getStartTime())));
			ps.setString(4, bean.getFileId());
			
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
                id = rs.getInt(1);
                bean.setId(id);
            }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}
		
		/**
		 * 改
		 * @param bean
		 */
		public void update(Project bean) {
			  
	        String sql = "update project set name= ? , address = ? , starttime = ? , fileid = ? where id = ? ";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	        	ps.setString(1, bean.getName());
				ps.setString(2, bean.getAddress());
				ps.setDate(3, DateUtil.d2t(DateUtil.str2u(bean.getStartTime())));
				ps.setString(4, bean.getFileId());
	            ps.setInt(5, bean.getId());
	  
	            ps.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	  
	    }
	  
		/**
		 * 删
		 * @param id
		 */
	    public void delete(int id) {
	  
	        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	  
	            String sql = "delete from project where id = " + id;
	  
	            s.execute(sql);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 通过id查询
	     * @param id
	     * @return
	     */
	    public Project get(int id) {
	    	Project bean = null;
	  
	    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    		  
	            String sql = "select * from project where id = " + id;
	  
	            ResultSet rs = s.executeQuery(sql);
	  
	            if (rs.next()) {
	                bean = new Project();
	                
	                String name = rs.getString("name");
	                bean.setName(name);
	                String address = rs.getString("address");
	                bean.setAddress(address);
	                String starttime = DateUtil.u2str(DateUtil.t2d(rs.getDate("starttime")));
	                bean.setStartTime(starttime);
	                String fileId = rs.getString("fileid");
	                bean.setFileId(fileId);
	                
	                bean.setId(id);
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return bean;
	    }

}
