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
import com.shm.bean.Sensor;
import com.shm.bean.User;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;

public class SensorDao {
	
	/**
	 * 统计数量
	 * @return
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			
			String sql = "select count(*) from sensor";
			
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
	
	public Sensor achieve(int id) {
    	Sensor bean = null;
  
    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
    		  
            String sql = "select * from sensor where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                bean = new Sensor();
                
                String name = rs.getString("name");
                bean.setName(name);
                Date installingTime = DateUtil.t2d(rs.getDate("installingtime"));
                bean.setInstallingTime(installingTime);
                String samplingFrequency = rs.getString("samplingfrequency");
                bean.setSamplingFrequency(samplingFrequency);
                String operationCondition = rs.getString("operationcondition");
                bean.setOperationCondition(operationCondition);
                String maintenanceRecord = rs.getString("maintenancerecord");
                bean.setMaintenanceRecord(maintenanceRecord);
                int elementId = rs.getInt("elementid");
                bean.setElementId(elementId);
                int stid = rs.getInt("stid");
                bean.setStid(stid);
                int pid = rs.getInt("pid");
                bean.setPid(pid);
                
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
	public void add(Sensor bean) {
		String sql = "insert into sensor values(null ,? ,?, ?, ?, ?, ?, ?, ? )";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setString(1, bean.getName());
			ps.setDate(2, DateUtil.d2t(bean.getInstallingTime()));
			ps.setString(3, bean.getSamplingFrequency());
			ps.setString(4, bean.getOperationCondition());
			ps.setString(5, bean.getMaintenanceRecord());
			ps.setInt(6, bean.getElementId());
			ps.setInt(7, bean.getStid());
			ps.setInt(8, bean.getPid());
			
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
		public void update(Sensor bean) {
			  
	        String sql = "update sensor set name= ? , installingtime = ? , samplingfrequency = ? , operationcondition = ? , maintenancerecord = ? , elementid = ? , stid = ?, pid = ? where id = ? ";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	        	ps.setString(1, bean.getName());
				ps.setDate(2, DateUtil.d2t(bean.getInstallingTime()));
				ps.setString(3, bean.getSamplingFrequency());
				ps.setString(4, bean.getOperationCondition());
				ps.setString(5, bean.getMaintenanceRecord());
				ps.setInt(6, bean.getElementId());
				ps.setInt(7, bean.getStid());
				ps.setInt(8, bean.getPid());
				
	            ps.setInt(9, bean.getId());
	  
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
	  
	            String sql = "delete from sensor where id = " + id;
	  
	            s.execute(sql);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 查询所有
	     * @return
	     */
	    public List<Sensor> list() {
	        return list(0, Short.MAX_VALUE);
	    }
	    
	    /**
	     * 按id范围查询
	     * @param start
	     * @param count
	     * @return
	     */
	    public List<Sensor> list(int start, int count) {
	        List<Sensor> beans = new ArrayList<Sensor>();
	  
	        String sql = "select * from sensor order by id desc limit ?,? ";
	  
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                Sensor bean = new Sensor();
	                int id = rs.getInt(1);
	 
	                String name = rs.getString("name");
	                bean.setName(name);
	                Date installingTime = DateUtil.t2d(rs.getDate("installingtime"));
	                bean.setInstallingTime(installingTime);
	                String samplingFrequency = rs.getString("samplingfrequency");
	                bean.setSamplingFrequency(samplingFrequency);
	                String operationCondition = rs.getString("operationcondition");
	                bean.setOperationCondition(operationCondition);
	                String maintenanceRecord = rs.getString("maintenancerecord");
	                bean.setMaintenanceRecord(maintenanceRecord);
	                int elementId = rs.getInt("elementid");
	                bean.setElementId(elementId);
	                int stid = rs.getInt("stid");
	                bean.setStid(stid);
	                int pid = rs.getInt("pid");
	                bean.setPid(pid);
	               
	                
	                bean.setId(id);
	                beans.add(bean);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return beans;
	    }
	    
	    /**
	     * 通过pid查询
	     * @param pid
	     * @return
	     */
	    public List<Sensor> get(int pid) {
	    	List<Sensor> beans = new ArrayList<Sensor>();
	    	String sql = "select * from sensor where pid = " + pid;
	  
	    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    		
	            ResultSet rs = s.executeQuery(sql);
	  
	            while (rs.next()) {
	                Sensor bean = new Sensor();
	                
	                int id = rs.getInt(1);
	                bean.setId(id);
	                String name = rs.getString("name");
	                bean.setName(name);
	                Date installingTime = DateUtil.t2d(rs.getDate("installingtime"));
	                bean.setInstallingTime(installingTime);
	                String samplingFrequency = rs.getString("samplingfrequency");
	                bean.setSamplingFrequency(samplingFrequency);
	                String operationCondition = rs.getString("operationcondition");
	                bean.setOperationCondition(operationCondition);
	                String maintenanceRecord = rs.getString("maintenancerecord");
	                bean.setMaintenanceRecord(maintenanceRecord);
	                int elementId = rs.getInt("elementid");
	                bean.setElementId(elementId);
	                int stid = rs.getInt("stid");
	                bean.setStid(stid);
	                
	                bean.setPid(pid);
	                beans.add(bean);
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return beans;
	    }

}
