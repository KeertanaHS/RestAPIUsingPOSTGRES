/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.service;

import com.resto.dao.DAOClass;
import com.resto.model.Ingrediant;
import com.resto.model.Recipe;
import com.resto.model.ResetPassword;
import com.resto.model.Unit;
import com.resto.model.User;
import com.resto.model.Veter;
import java.util.List;
import java.util.Map;

/**
 *Keertana H S
 * 
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


public String addRecipes( Recipe recipes){
	
	String uniqueId = "R"+System.currentTimeMillis();
        String returnString = "failed";
	String recipeId = daoClass.addRecipes(recipes, uniqueId);
	
	for(Ingrediant ingrediant : recipes.getIngrediantList()){
		int i = daoClass.addIngerdiant(ingrediant, recipeId);
                if(i > 0){
                    returnString = "success";
                }else{
                    returnString = "failed";
                }
	}
        	return returnString;
	}

public String addRecipeUnit( Unit unit){
	
	return daoClass.addRecipeUnit(unit);
}
public List<Recipe> getRecipes() {
	
	return daoClass.getRecipes();
}

public Recipe getSingleRecipe(String recipeId) {
	
	return null;
}

public String updateRecipePrice(Recipe recipe) {
	return daoClass.updateRecipePrice(recipe);
}

public String deleteRecipe(String recipeId) {
	return daoClass.deleteRecipe(recipeId);
}

public String veterRegistration( Veter veter){
	String returnString = "failed";
	boolean flag = daoClass.veterRegistration(veter);
        if(flag){
	returnString = "success";
        }
	
        return returnString;
	}

public  Map<String, Object> getVeters() {
	
	return daoClass.getVeters();
}

public Map<String, Object> getVeterById(String userId) {
	return daoClass.getVeterById(userId);
}

public String updateVeter(Veter veter) {
	
	return daoClass.updateVeter(veter);
}

public String deleteVeter(String userId) {
	return daoClass.deleteVeter(userId);
}



public String resetPassword(ResetPassword resetPass) {
    
    return daoClass.resetPassword(resetPass);
}

public String addFavouriteRecipe(String userId, String recipeId) {
    
    return daoClass.addFavouriteRecipe(userId, recipeId);
}

public String deleteFavouriteRecipe(String userFavouriteRecipeId) {
    
    return daoClass.deleteFavouriteRecipe(userFavouriteRecipeId);
}

public List<Recipe> getFevouriteRecipes(String userId) {
    
    return daoClass.getFevouriteRecipes(userId);
}

}
