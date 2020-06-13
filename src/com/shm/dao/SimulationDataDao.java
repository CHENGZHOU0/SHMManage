package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shm.bean.Sensor;
import com.shm.bean.SimulationData;
import com.shm.utils.DBUtil;
import com.shm.utils.DateUtil;

public class SimulationDataDao {
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			
			String sql = "select count(*) from monitoringdata";
			
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
	
	public int add(SimulationData bean) {
		int id = 0;
		String sql = "insert into monitoringdata values(null ,? ,?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sf.parse(bean.getTime());
			ps.setTimestamp(1, DateUtil.u2s(date));
			
			ps.setString(2, bean.getValue1());
			ps.setString(3, bean.getValue2());
			ps.setString(4, bean.getValue3());
			ps.setInt(5, bean.getSid());
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
                id = rs.getInt(1);
                bean.setId(id);
            }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	
	public SimulationData getAverage(String likeTime, int sid) {
		
		SimulationData average = new SimulationData();
		
		List<SimulationData> beans = new ArrayList<SimulationData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
        	
			String sql = "select * from monitoringdata where time like '" + likeTime + "' and sid = " + sid;
        	
        	ResultSet rs = s.executeQuery(sql);
        	
        	while (rs.next()) {
        		SimulationData bean = new SimulationData();
                
                int id = rs.getInt("id");
                bean.setId(id);
                
                Timestamp time = rs.getTimestamp("time");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(DateUtil.s2u(time));
                bean.setTime(date);
                
                String value1 = rs.getString("value1");
                bean.setValue1(value1);
                String value2 = rs.getString("value2");
                bean.setValue2(value2);
                String value3 = rs.getString("value3");
                bean.setValue3(value3);
                
                bean.setSid(sid);
                
                beans.add(bean); 
            }
        	
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
		
		if (beans.size()>0) {
			
			double value1total = 0;
			double value2total = 0;
			double value3total = 0;
			double value1avg = 0;
			double value2avg = 0;
			double value3avg = 0;
			
			for (int i = 0; i < beans.size(); i++) {
				System.out.println(beans.get(i).getValue1());
				
				value1total = value1total + Double.parseDouble(beans.get(i).getValue1());
				value2total = value2total + Double.parseDouble(beans.get(i).getValue2());
				value3total = value3total + Double.parseDouble(beans.get(i).getValue3());
			}
			
			value1avg = value1total / beans.size();
			value2avg = value2total / beans.size();
			value3avg = value3total / beans.size();
			
			DecimalFormat df = new DecimalFormat("0.0000");
			
			average.setValue1(df.format(value1avg));
			average.setValue2(df.format(value2avg));
			average.setValue3(df.format(value3avg));
			
			average.setTime(likeTime.substring(0,10));
		}
		  
        
		return average;
    }
	
	public SimulationData getMax(String likeTime, int sid) {
		
		SimulationData max = new SimulationData();
		
		List<SimulationData> beans = new ArrayList<SimulationData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
        	
			String sql = "select * from monitoringdata where time like '" + likeTime + "' and sid = " + sid;
        	
        	ResultSet rs = s.executeQuery(sql);
        	
        	while (rs.next()) {
        		SimulationData bean = new SimulationData();
                
        		int id = rs.getInt("id");
                bean.setId(id);
                
                Timestamp time = rs.getTimestamp("time");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(DateUtil.s2u(time));
                bean.setTime(date);
                
                String value1 = rs.getString("value1");
                bean.setValue1(value1);
                String value2 = rs.getString("value2");
                bean.setValue2(value2);
                String value3 = rs.getString("value3");
                bean.setValue3(value3);
                
                bean.setSid(sid);
                
                beans.add(bean);
            }
        	
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
		
		if (beans.size()>0) {
			
			double value1max = Double.parseDouble(beans.get(0).getValue1());
			double value2max = Double.parseDouble(beans.get(0).getValue2());
			double value3max = Double.parseDouble(beans.get(0).getValue3());
			
			for (int i = 0; i < beans.size(); i++) {
				if (Double.parseDouble(beans.get(i).getValue1()) > value1max) {
					value1max = Double.parseDouble(beans.get(i).getValue1());
				}
				if (Double.parseDouble(beans.get(i).getValue2()) > value2max) {
					value2max = Double.parseDouble(beans.get(i).getValue2());
				}
				if (Double.parseDouble(beans.get(i).getValue3()) > value3max) {
					value3max = Double.parseDouble(beans.get(i).getValue3());
				}
				
			}
			
			if (String.valueOf(value1max).length() > 7) {
				max.setValue1(String.valueOf(value1max).substring(0,7));
			}
			if (String.valueOf(value2max).length() > 7) {
				max.setValue2(String.valueOf(value2max).substring(0,7));
			}
			
			max.setValue3(String.valueOf(value3max));
			max.setTime(likeTime.substring(0,10));
		}
		  
        
		return max;
    }

	public SimulationData getMin(String likeTime, int sid) {
		
		SimulationData min = new SimulationData();
		
		List<SimulationData> beans = new ArrayList<SimulationData>();
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    	
			String sql = "select * from monitoringdata where time like '" + likeTime + "' and sid =" + sid;
	    	
	    	ResultSet rs = s.executeQuery(sql);
	    	
	    	while (rs.next()) {
	    		SimulationData bean = new SimulationData();
	            
	    		int id = rs.getInt("id");
                bean.setId(id);
                
                Timestamp time = rs.getTimestamp("time");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(DateUtil.s2u(time));
                bean.setTime(date);
                
                String value1 = rs.getString("value1");
                bean.setValue2(value1);
                String value2 = rs.getString("value2");
                bean.setValue3(value2);
                String value3 = rs.getString("value3");
                bean.setValue1(value3);
                
                bean.setSid(sid);
                
                beans.add(bean);
	        }
	    	
	    } catch (SQLException e) {
	
	        e.printStackTrace();
	    }
		
		if (beans.size()>0) {
			
			double value1min = Double.parseDouble(beans.get(0).getValue1());
			double value2min = Double.parseDouble(beans.get(0).getValue2());
			double value3min = Double.parseDouble(beans.get(0).getValue3());
			
			for (int i = 0; i < beans.size(); i++) {
				if (Double.parseDouble(beans.get(i).getValue1()) < value1min) {
					value1min = Double.parseDouble(beans.get(i).getValue1());
				}
				if (Double.parseDouble(beans.get(i).getValue2()) < value2min) {
					value2min = Double.parseDouble(beans.get(i).getValue2());
				}
				if (Double.parseDouble(beans.get(i).getValue3()) < value3min) {
					value3min = Double.parseDouble(beans.get(i).getValue3());
				}
				
			}
			
			
			min.setValue1(String.valueOf(value1min).substring(0,7));
			min.setValue2(String.valueOf(value2min).substring(0,7));
			min.setValue3(String.valueOf(value3min));
			min.setTime(likeTime.substring(0,10));
		}
		  
	    
		return min;
	}
	
	public SimulationData getNew(int sid) {
		
		SimulationData bean = null;
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	    	
			String sql = "select * from monitoringdata where sid = " + sid + " order by time desc limit 0,1";
	    	
			ResultSet rs = s.executeQuery(sql);
	    	
	    	while (rs.next()) {
	            bean = new SimulationData();
	            
	            int id = rs.getInt("id");
                bean.setId(id);
                
                Timestamp time = rs.getTimestamp("time");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(DateUtil.s2u(time));
                bean.setTime(date);
                
                String value1 = rs.getString("value1");
                bean.setValue1(value1);
                String value2 = rs.getString("value2");
                bean.setValue1(value2);
                String value3 = rs.getString("value3");
                bean.setValue1(value3);
                
                //bean.setSid(sid);
	            
	        }
	    	
	    } catch (SQLException e) {
	
	        e.printStackTrace();
	    }
		
		return bean;
	}
	
	
	/**
	 * 
	 * @param likeTime
	 * @param sid
	 * @return
	 */
	public List<SimulationData> getWarning(String startTime, String endTime, int sid) {
		
		List<SimulationData> beans = new ArrayList<SimulationData>();
		
		String sql = "select * from monitoringdata where sid =" + sid + " and (value1>0.95 or value1<-0.95 or value2>0.95 or value2<-0.95 or value3 > 0.95 or value3<-0.95) and time between ? and ?";
		
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	    	
			ps.setString(1, startTime);
            ps.setString(2, endTime);
  
            ResultSet rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    		SimulationData bean = new SimulationData();
	            
	    		int id = rs.getInt("id");
                bean.setId(id);
                
                Timestamp time = rs.getTimestamp("time");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(DateUtil.s2u(time));
                bean.setTime(date);
                
                String value1 = rs.getString("value1");
                bean.setValue2(value1);
                String value2 = rs.getString("value2");
                bean.setValue3(value2);
                String value3 = rs.getString("value3");
                bean.setValue1(value3);
                
                bean.setSid(sid);
                beans.add(bean);
	        }
		} catch (SQLException e) {
			  
            e.printStackTrace();
        }
		  
	    
		return beans;
	}

}
