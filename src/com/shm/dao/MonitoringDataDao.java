package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shm.bean.MonitoringData;
import com.shm.bean.Project;
import com.shm.bean.Sensor;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;

public class MonitoringDataDao {
	
	
	public MonitoringData getAverage(String likeTime, int sid) {
		
		MonitoringData average = new MonitoringData();
		
		List<MonitoringData> beans = new ArrayList<MonitoringData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
        	
			String sql = "select * from sanyue where time like '" + likeTime + "' and sensor_id = " + sid;
        	
        	ResultSet rs = s.executeQuery(sql);
        	
        	while (rs.next()) {
                MonitoringData bean = new MonitoringData();
                
                int id = rs.getInt("id");
                bean.setId(id);
                String time = rs.getString("time");
                bean.setTime(time);
                String sensorId = rs.getString("sensor_id");
                bean.setSensorId(sensorId);
                String sensorType = rs.getString("sensor_type");
                bean.setSensorType(sensorType);
                String x = rs.getString("x");
                bean.setX(x);
                String y = rs.getString("y");
                bean.setY(y);
                String t = rs.getString("t");
                bean.setT(t);
                
                beans.add(bean); 
            }
        	
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
		
		if (beans.size()>0) {
			
			double xtotal = 0;
			double ytotal = 0;
			double ttotal = 0;
			double xavg = 0;
			double yavg = 0;
			double tavg = 0;
			
			for (int i = 0; i < beans.size(); i++) {
				xtotal = xtotal + Double.parseDouble(beans.get(i).getX());
				ytotal = ytotal + Double.parseDouble(beans.get(i).getY());
				ttotal = ttotal + Double.parseDouble(beans.get(i).getT());
			}
			
			//将角度值转为斜率
			xavg = Math.tan(Math.PI/180*(xtotal / beans.size()));
			yavg = Math.tan(Math.PI/180*(ytotal / beans.size()));
			tavg = ttotal / beans.size();
			
			average.setX(String.valueOf(xavg).substring(0,7));
			average.setY(String.valueOf(yavg).substring(0,7));
			average.setT(String.valueOf(tavg).substring(0,4));
			average.setTime(likeTime.substring(0,10));
		}
		  
        
		return average;
    }
	
	public MonitoringData getMax(String likeTime, int sid) {
		
		MonitoringData max = new MonitoringData();
		
		List<MonitoringData> beans = new ArrayList<MonitoringData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
        	
			String sql = "select * from sanyue where time like '" + likeTime + "' and sensor_id = " + sid;
        	
        	ResultSet rs = s.executeQuery(sql);
        	
        	while (rs.next()) {
                MonitoringData bean = new MonitoringData();
                
                int id = rs.getInt("id");
                bean.setId(id);
                String time = rs.getString("time");
                bean.setTime(time);
                String sensorId = rs.getString("sensor_id");
                bean.setSensorId(sensorId);
                String sensorType = rs.getString("sensor_type");
                bean.setSensorType(sensorType);
                String x = rs.getString("x");
                bean.setX(x);
                String y = rs.getString("y");
                bean.setY(y);
                String t = rs.getString("t");
                bean.setT(t);
                
                beans.add(bean); 
            }
        	
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
		
		if (beans.size()>0) {
			
			double xmax = Double.parseDouble(beans.get(0).getX());
			double ymax = Double.parseDouble(beans.get(0).getY());
			double tmax = Double.parseDouble(beans.get(0).getT());
			
			for (int i = 0; i < beans.size(); i++) {
				if (Double.parseDouble(beans.get(i).getX()) > xmax) {
					xmax = Double.parseDouble(beans.get(i).getX());
				}
				if (Double.parseDouble(beans.get(i).getY()) > ymax) {
					ymax = Double.parseDouble(beans.get(i).getY());
				}
				if (Double.parseDouble(beans.get(i).getT()) > tmax) {
					tmax = Double.parseDouble(beans.get(i).getT());
				}
				
			}
			
			//将角度值转为斜率
			xmax = Math.tan(Math.PI/180*xmax);
			ymax = Math.tan(Math.PI/180*ymax);
			
			
			max.setX(String.valueOf(xmax).substring(0,7));
			max.setY(String.valueOf(ymax).substring(0,7));
			max.setT(String.valueOf(tmax));
			max.setTime(likeTime.substring(0,10));
		}
		  
        
		return max;
    }

	public MonitoringData getMin(String likeTime, int sid) {
		
		MonitoringData min = new MonitoringData();
		
		List<MonitoringData> beans = new ArrayList<MonitoringData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    	
			String sql = "select * from sanyue where time like '" + likeTime + "' and sensor_id = " + sid;
	    	
	    	ResultSet rs = s.executeQuery(sql);
	    	
	    	while (rs.next()) {
	            MonitoringData bean = new MonitoringData();
	            
	            int id = rs.getInt("id");
	            bean.setId(id);
	            String time = rs.getString("time");
	            bean.setTime(time);
	            String sensorId = rs.getString("sensor_id");
	            bean.setSensorId(sensorId);
	            String sensorType = rs.getString("sensor_type");
	            bean.setSensorType(sensorType);
	            String x = rs.getString("x");
	            bean.setX(x);
	            String y = rs.getString("y");
	            bean.setY(y);
	            String t = rs.getString("t");
	            bean.setT(t);
	            
	            beans.add(bean); 
	        }
	    	
	    } catch (SQLException e) {
	
	        e.printStackTrace();
	    }
		
		if (beans.size()>0) {
			
			double xmin = Double.parseDouble(beans.get(0).getX());
			double ymin = Double.parseDouble(beans.get(0).getY());
			double tmin = Double.parseDouble(beans.get(0).getT());
			
			for (int i = 0; i < beans.size(); i++) {
				if (Double.parseDouble(beans.get(i).getX()) < xmin) {
					xmin = Double.parseDouble(beans.get(i).getX());
				}
				if (Double.parseDouble(beans.get(i).getY()) < ymin) {
					ymin = Double.parseDouble(beans.get(i).getY());
				}
				if (Double.parseDouble(beans.get(i).getT()) < tmin) {
					tmin = Double.parseDouble(beans.get(i).getT());
				}
				
			}
			
			//将角度值转为斜率
			xmin = Math.tan(Math.PI/180*xmin);
			ymin = Math.tan(Math.PI/180*ymin);
			
			
			min.setX(String.valueOf(xmin).substring(0,7));
			min.setY(String.valueOf(ymin).substring(0,7));
			min.setT(String.valueOf(tmin));
			min.setTime(likeTime.substring(0,10));
		}
		  
	    
		return min;
	}
	
	public MonitoringData getNew(int sid) {
		
		MonitoringData bean = null;
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    	
			String sql = "select * from sanyue where sensor_id = " + sid + " order by id DESC LIMIT 0,1";
	    	
			ResultSet rs = s.executeQuery(sql);
	    	
	    	while (rs.next()) {
	            bean = new MonitoringData();
	            
	            int id = rs.getInt("id");
	            bean.setId(id);
	            String time = rs.getString("time");
	            bean.setTime(time);
	            String sensorId = rs.getString("sensor_id");
	            bean.setSensorId(sensorId);
	            String sensorType = rs.getString("sensor_type");
	            bean.setSensorType(sensorType);
	            String x = rs.getString("x");
	            bean.setX(x);
	            String y = rs.getString("y");
	            bean.setY(y);
	            String t = rs.getString("t");
	            bean.setT(t);
	            
	        }
	    	
	    } catch (SQLException e) {
	
	        e.printStackTrace();
	    }
		
		return bean;
	}

	
  
}

