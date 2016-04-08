package com.resto.dao;

/*
*Keertana H S
*
*/

import com.resto.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOClass {
	
    public boolean userRegistration( User user){
        boolean flag = false;
        Connection conn = null;
        try {
            String insertUser = "INSERT INTO \"Unhoven\".user_master(usr_unique_id, email, mobile, first_name, last_name, "
                    + "address1, address2, city, state, country, usr_password) VALUES "
                    + "( 'USR"+System.currentTimeMillis()+"', '"+user.getEmail()+"', '"+user.getMobile()+"', '"+user.getFirstName()+"', "
                    + " '"+user.getLastName()+"', '"+user.getAddr1()+"', '"+user.getAddr2()+"', '"+user.getCity()+"', '"+user.getState()+"', "
                    + "  '"+user.getCountry()+"', '"+user.getPassword()+"')";
            System.out.println("insertUser <<<<<<<<<<<<<  : " +insertUser);
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertUser);
            int i = pstmt.executeUpdate();
            if(i > 0){
                flag = true;
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         DBClass.clossConnection(conn);
        }
        return flag;
	}
    
    public Map<String, Object> login(User userDetails) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
            try {
                
             String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE email = '"+userDetails.getEmail()+"' AND usr_password = '"+userDetails.getPassword()+"'";
                System.out.println(">>>>>>>>>>>>>  "+loginQuery);
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		
		return returnMap;
	}

	public boolean checkUserExist(User userDetails) {
            Connection conn = null;
            boolean flag = false;
            try {
            String checkQuery = "SELECT COUNT(ID) cnt FROM \"Unhoven\".user_master WHERE email = '"+userDetails.getEmail()+"' ";;
            conn = DBClass.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(checkQuery);
                ResultSet rs = pstmt.executeQuery();
                int cnt = 0;
                
                while(rs.next()){
                    cnt = rs.getInt("cnt");
                }
                if(cnt > 0){
                    flag = true;
                }else{
                   flag = false; 
                }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return flag;
	}
        
        public String updateUser(User userDetails) {
            String returnString = "failed";
            Connection conn = null;
           try {
            String updateUser = "UPDATE \"Unhoven\".user_master "
                    + "SET   first_name='"+userDetails.getFirstName()+"', last_name='"+userDetails.getLastName()+"', "
                    + "address1='"+userDetails.getAddr1()+"', address2='"+userDetails.getAddr2()+"', city='"+userDetails.getCity()+"', "
                    + "state='"+userDetails.getState()+"', country='"+userDetails.getCountry()+"' "
                    + "WHERE id= "+userDetails.getId()+"";
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(updateUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString =  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnString;
	}

	public String deleteUser(String userId) {
            String returnString = "failed";
            Connection conn = null;
            try {
            String deleteUser = "DELETE FROM \"Unhoven\".user_master " 
                            +" WHERE id = '"+userId+"'";
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(deleteUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString=  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
          return returnString;
	}

	public Map<String, Object> getUser(String emailId) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
            conn = DBClass.getConnection();
            String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE email = '"+emailId+"' ";
                System.out.println("getUserByEmail Query>>>>>>>>>>>>>  "+loginQuery);
            
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
	
	public Map<String, Object> getUserById(String userId) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
            conn = DBClass.getConnection();
            String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE id = "+userId+" ";
                System.out.println("getUserById Query>>>>>>>>>>>>>  "+loginQuery);
            
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
        
    
}
