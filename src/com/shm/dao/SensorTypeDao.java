package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shm.bean.Project;
import com.shm.bean.SensorType;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;


public class SensorTypeDao {
	/**
	 * 统计数量
	 * @return
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			
			String sql = "select count(*) from sensortype";
			
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
	
	
	
	public SensorType get(int id) {
		SensorType bean = null;
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  		  
            String sql = "select * from sensortype where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                bean = new SensorType();
                
                String name = rs.getString("name");
                bean.setName(name);
                String parameter1 = rs.getString("parameter1");
                bean.setParameter1(parameter1);
                Float upperlimit1 = rs.getFloat("upperlimit1");
                bean.setUpperlimit1(upperlimit1);
                Float lowerlimit1 = rs.getFloat("lowerlimit1");
                bean.setLowerlimit1(lowerlimit1);
                
                String parameter2 = rs.getString("parameter2");
                bean.setParameter2(parameter2);
                Float upperlimit2 = rs.getFloat("upperlimit2");
                bean.setUpperlimit2(upperlimit2);
                Float lowerlimit2 = rs.getFloat("lowerlimit2");
                bean.setLowerlimit2(lowerlimit2);
                
                String parameter3 = rs.getString("parameter3");
                bean.setParameter3(parameter3);
                Float upperlimit3 = rs.getFloat("upperlimit3");
                bean.setUpperlimit3(upperlimit3);
                Float lowerlimit3 = rs.getFloat("lowerlimit3");
                bean.setLowerlimit3(lowerlimit3);
                
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
		
		
		return bean;
		
	}
	
	
	
	/**
	 * 增
	 * @param bean
	 */
	public void add(SensorType bean) {
		String sql = "insert into sensortype values(null ,? ,?, ?, ?, ?, ?, ?, ?, ?, ? )";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getParameter1());
			ps.setFloat(3, bean.getUpperlimit1());
			ps.setFloat(4, bean.getLowerlimit1());
			ps.setString(5, bean.getParameter2());
			ps.setFloat(6, bean.getUpperlimit2());
			ps.setFloat(7, bean.getLowerlimit2());
			ps.setString(8, bean.getParameter3());
			ps.setFloat(9, bean.getUpperlimit3());
			ps.setFloat(10, bean.getLowerlimit3());
			
			
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
		
		/**
		 * 改
		 * @param bean
		 */
		public void update(SensorType bean) {
			  
	        String sql = "update sensortype set name= ? , parameter1 = ? , upperlimit1 = ? , lowerlimit1 = ? , parameter2 = ? , upperlimit2 = ? , lowerlimit2 = ? , parameter3 = ? , upperlimit3 = ? , lowerlimit3 = ?  where id = ? ";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	        	ps.setString(1, bean.getName());
				ps.setString(2, bean.getParameter1());
				ps.setFloat(3, bean.getUpperlimit1());
				ps.setFloat(4, bean.getLowerlimit1());
				ps.setString(5, bean.getParameter2());
				ps.setFloat(6, bean.getUpperlimit2());
				ps.setFloat(7, bean.getLowerlimit2());
				ps.setString(8, bean.getParameter3());
				ps.setFloat(9, bean.getUpperlimit3());
				ps.setFloat(10, bean.getLowerlimit3());
				
	            ps.setInt(11, bean.getId());
	  
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
	  
	            String sql = "delete from sensortype where id = " + id;
	  
	            s.execute(sql);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 查询所有
	     * @return
	     */
	    public List<SensorType> list() {
	        return list(0, Short.MAX_VALUE);
	    }
	    
	    /**
	     * 按id范围查询
	     * @param start
	     * @param count
	     * @return
	     */
	    public List<SensorType> list(int start, int count) {
	        List<SensorType> beans = new ArrayList<SensorType>();
	  
	        String sql = "select * from sensortype order by id desc limit ?,? ";
	  
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	            
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                SensorType bean = new SensorType();
	                int id = rs.getInt(1);
	 
	                String name = rs.getString("name");
	                bean.setName(name);
	                String parameter1 = rs.getString("parameter1");
	                bean.setParameter1(parameter1);
	                Float upperlimit1 = rs.getFloat("upperlimit1");
	                bean.setUpperlimit1(upperlimit1);
	                Float lowerlimit1 = rs.getFloat("lowerlimit1");
	                bean.setLowerlimit1(lowerlimit1);
	                
	                String parameter2 = rs.getString("parameter2");
	                bean.setParameter2(parameter2);
	                Float upperlimit2 = rs.getFloat("upperlimit2");
	                bean.setUpperlimit2(upperlimit2);
	                Float lowerlimit2 = rs.getFloat("lowerlimit2");
	                bean.setLowerlimit2(lowerlimit2);
	                
	                String parameter3 = rs.getString("parameter3");
	                bean.setParameter3(parameter3);
	                Float upperlimit3 = rs.getFloat("upperlimit3");
	                bean.setUpperlimit3(upperlimit3);
	                Float lowerlimit3 = rs.getFloat("lowerlimit3");
	                bean.setLowerlimit3(lowerlimit3);
	                
	               
	                
	                bean.setId(id);
	                beans.add(bean);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return beans;
	    }

		
}
