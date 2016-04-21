/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.controller;

import com.resto.model.Ingrediant;
import com.resto.model.Recipe;
import com.resto.model.ResetPassword;
import com.resto.model.Unit;
import com.resto.service.UserService;
import com.resto.model.User;
import com.resto.model.Veter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



/**
 *Keertana H S
 * 
 */
@Path("/")
public class UserController {

       UserService serciveClass = new UserService();
        private static final String SUCCESS_RESULT="<result>success</result>";
        private static final String FAILURE_RESULT="<result>failure</result>";
   
        @POST
	@Path(UriInfo.CREATE_USER)
	@Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> createUser( User user)throws IOException{
            System.out.println(">>>>>>>>>>>>  "+ user.getCity());
			//User user = new User( email, password, mobile, firstName, lastName, addr1, addr2, city, state, country);
                        String str = serciveClass.userRegistration(user);
                        System.out.println("str>>>>>>>>>>>>  "+ str);
                        //str = "{ result : "+str+"}";
                        Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;//serciveClass.userRegistration(user);
	}
     
        @POST
	@Path(UriInfo.LOGIN_USER)
	@Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	public Map<String, Object> loginUser(User userDetails)throws IOException{
			//User userDetails = new User( email, password);
			 System.out.println(".........."+userDetails.getEmail());
         //User user = serciveClass.login(userDetails);
        return serciveClass.login(userDetails);
	}
        
        @PUT
	@Path(UriInfo.UPDATE_USER)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> updateUser(User user)throws IOException{
			//User user = new User(id, firstName, lastName, addr1, addr2, city, state, country);
			String str = serciveClass.updateUser(user);
                         Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
    
    
        @GET
	@Path(UriInfo.GET_USER_BY_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getUserBYId(@PathParam("userId") String userId){
		 Map<String, Object> user = serciveClass.getUserById(userId);

                return user;
		
	}
        @GET
	@Path(UriInfo.GET_USER_BY_EMAIL)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getUserByEmail(@PathParam("emailId") String emailId){
		Map<String, Object> user = serciveClass.getUser(emailId);

                return user;
		
	}
     
        @DELETE
	@Path(UriInfo.DELETE_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> deleteUser(
		@PathParam("userId") String userId){
		 String str =  serciveClass.deleteUser(userId);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
     
        @POST
	@Path(UriInfo.CREATE_RECIPE)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> createRecipe(Recipe recipe)throws IOException{
			//Recipe recipe = new Recipe( recipeId, recipeName, recipeImageUrl, recipePricePerUnit, recipeUnitId, recipeDescription, recipePosterId, ingrediantList);
			String str = serciveClass.addRecipes(recipe);
                         Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
     
        @GET
	@Path(UriInfo.GET_RECIPES)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getRecipes(){
		 List<Recipe> recipes = serciveClass.getRecipes();
        return recipes;
		
	}
        
        @PUT
	@Path(UriInfo.UPDATE_RECIPE)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> updateRecipePrice(Recipe recipe)throws IOException{
			//Recipe recipe = new Recipe(id, recipePricePerUnit);
			
		String str = serciveClass.updateRecipePrice(recipe);
                Map<String, String> returnMap = new HashMap<String, String>();
                returnMap.put("responce", str);
                                
		return returnMap;
	}
     
    
        @GET
	@Path(UriInfo.GET_RECIPE_BY_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getSingleRecipe(@PathParam("recipeId") String recipeId){
		Recipe recipe = serciveClass.getSingleRecipe(recipeId);

                return recipe;
		
	}
        
        @DELETE
	@Path(UriInfo.DELETE_RECIPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> deleteRecipe(
		@PathParam("recipeId") String recipeId){
		String str = serciveClass.deleteRecipe(recipeId);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
        
        @POST
	@Path(UriInfo.CREATE_UNIT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> createUnit( Unit unit)throws IOException{
			//Unit unit = new Unit( unitName);
			String str = serciveClass.addRecipeUnit(unit);
                         Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}  
        
        @POST
	@Path(UriInfo.CREATE_VETER)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> createVeter(Veter veter )throws IOException{
			//Veter veter = new Veter( mobile, firstName, lastName, city, country);
			 String str = serciveClass.veterRegistration(veter);
                          Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	} 
        
        @PUT
	@Path(UriInfo.UPDATE_VETER)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> updateVeter( Veter veter)throws IOException{
			//Veter veter = new Veter(id, mobile,firstName, lastName, city, country);
			 String str = serciveClass.updateVeter(veter);
                          Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
        
        @GET
	@Path(UriInfo.GET_VETER_BY_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getVeterById(@PathParam("veterId") String veterId){
		 Map<String, Object> user = serciveClass.getVeterById(veterId);

        return user;
		
	}
        
        @GET
	@Path(UriInfo.GET_VETER)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getVeters(){
		 Map<String, Object> user = serciveClass.getVeters();

        return user;
		
	}
   
        @DELETE
	@Path(UriInfo.DELETE_VETER)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> deleteVeter(
		@PathParam("veterId") String veterId){
		String str =  serciveClass.deleteVeter(veterId);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
    
        @POST
	@Path(UriInfo.RESET_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
	public Map<String, String> resetPassword(ResetPassword resetPass){
            //ResetPassword resetPass = new ResetPassword(userid,oldPassword, newPassword );
		String str = serciveClass.resetPassword(resetPass);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
        
        @GET
	@Path(UriInfo.USER_FAVOURITE_RECIPE_ADD)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> addFavouriteRecipe(@PathParam("userId") String userId, @PathParam("recipeId") String recipeId){
		String str = serciveClass.addFavouriteRecipe(userId, recipeId);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
		
	}
        
        @DELETE
	@Path(UriInfo.USER_FAVOURITE_RECIPE_DELET)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> deleteFavouriteRecipe(
		@PathParam("userFavouriteRecipeId") String userFavouriteRecipeId){
		String str = serciveClass.deleteFavouriteRecipe(userFavouriteRecipeId);
                 Map<String, String> returnMap = new HashMap<String, String>();
                        returnMap.put("responce", str);
                                
			 return returnMap;
	}
        
        @GET
	@Path(UriInfo.GET_USER_FAVOURITE_RECIPE)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getFevouriteRecipes(@PathParam("userId") String userId){
		return serciveClass.getFevouriteRecipes(userId);
		
	}

}
