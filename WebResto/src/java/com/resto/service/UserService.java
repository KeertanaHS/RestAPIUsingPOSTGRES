/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.service;

import com.resto.dao.DAOClass;
import com.resto.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * Keertana H S
 */
public class UserService {
	
	DAOClass daoClass = new DAOClass();
	
    /**
     *
     * @param userDetails
     * @return
     */
    public String userRegistration( User userDetails){
	String returnString = "failed";
	boolean flag = daoClass.checkUserExist(userDetails);
	if(!flag){
	
	 daoClass.userRegistration(userDetails);
	 
         returnString = "success";
	}
		return returnString;
	}

    public Map<String, Object> login(User userDetails) {
	
	return daoClass.login(userDetails);
    }

public  Map<String, Object> getUser(String emailId) {
	
	return daoClass.getUser(emailId);
}

public Map<String, Object> getUserById(String userId) {
	return daoClass.getUserById(userId);
}

public String updateUser(User userDetails) {
	
	return daoClass.updateUser(userDetails);
}

public String deleteUser(String userId) {
	return daoClass.deleteUser(userId);
}

}
