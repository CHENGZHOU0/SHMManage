package com.shm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shm.bean.User;
import com.shm.utils.DBUtil;

public class UserDao {
	/**
	 * 统计数量
	 * @return
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			
			String sql = "select count(*) from user";
			
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
	public void add(User bean) {
		String sql = "insert into user values(null ,? ,?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			ps.setString(2, bean.getType());
			ps.setString(2, bean.getMailbox());
			
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
		public void update(User bean) {
			  
	        String sql = "update user set name= ? , password = ? , type = ? , mailbox = ? where id = ? ";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setString(1, bean.getName());
	            ps.setString(2, bean.getPassword());
	            ps.setString(3, bean.getType());
	            ps.setString(4, bean.getMailbox());
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
	  
	            String sql = "delete from user where id = " + id;
	  
	            s.execute(sql);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	  
	    /**
	     * 按id查询单条数据
	     * @param id
	     * @return
	     */
	    public User get(int id) {
	        User bean = null;
	  
	        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
	  
	            String sql = "select * from user where id = " + id;
	  
	            ResultSet rs = s.executeQuery(sql);
	  
	            if (rs.next()) {
	                bean = new User();
	                
	                String name = rs.getString("name");
	                bean.setName(name);
	                String password = rs.getString("password");
	                bean.setPassword(password);
	                String type = rs.getString("type");
	                bean.setType(type);
	                String mailbox = rs.getString("mailbox");
	                bean.setMailbox(mailbox);
	                
	                bean.setId(id);
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return bean;
	    }
	  
	    /**
	     * 查询所有
	     * @return
	     */
	    public List<User> list() {
	        return list(0, Short.MAX_VALUE);
	    }
	    
	    /**
	     * 按id范围查询
	     * @param start
	     * @param count
	     * @return
	     */
	    public List<User> list(int start, int count) {
	        List<User> beans = new ArrayList<User>();
	  
	        String sql = "select * from user order by id desc limit ?,? ";
	  
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                User bean = new User();
	                int id = rs.getInt(1);
	 
	                String name = rs.getString("name");
	                bean.setName(name);
	                String password = rs.getString("password");
	                bean.setPassword(password);
	                String type = rs.getString("type");
	                bean.setType(type);
	                String mailbox = rs.getString("mailbox");
	                bean.setMailbox(mailbox);
	                
	                bean.setId(id);
	                beans.add(bean);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return beans;
	    }
	 
	    /**
	     * 根据name判断用户是否存在
	     * @param name
	     * @return
	     */
	    public boolean isExist(String name) {
	        User user = get(name);
	        return user!=null;
	 
	    }
	    
	    /**
	     * 根据name查询用户
	     * @param name
	     * @return
	     */
	    public User get(String name) {
	        User bean = null;
	          
	        String sql = "select * from user where name = ?";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	            ps.setString(1, name);
	            ResultSet rs =ps.executeQuery();
	  
	            if (rs.next()) {
	                bean = new User();
	                int id = rs.getInt("id");
	                bean.setName(name);
	                String password = rs.getString("password");
	                bean.setPassword(password);
	                String type = rs.getString("type");
	                bean.setType(type);
	                String mailbox = rs.getString("mailbox");
	                bean.setMailbox(mailbox);
	                
	                bean.setId(id);
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return bean;
	    }
	 
	    /**
	     * 根据账号密码获取对象
	     * @param name
	     * @param password
	     * @return
	     */
	    public User get(String name, String password) {
	        User bean = null;
	          
	        String sql = "select * from user where name = ? and password=?";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	            ps.setString(1, name);
	            ps.setString(2, password);
	            ResultSet rs =ps.executeQuery();
	  
	            if (rs.next()) {
	                bean = new User();
	                int id = rs.getInt("id");
	                
	                String type = rs.getString("type");
	                bean.setType(type);
	                String mailbox = rs.getString("mailbox");
	                bean.setMailbox(mailbox);
	                
	                bean.setName(name);
	                bean.setPassword(password);
	                bean.setId(id);
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return bean;
	    }
		

}
