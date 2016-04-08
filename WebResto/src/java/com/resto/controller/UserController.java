/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resto.controller;


import com.resto.service.UserService;
import com.resto.model.User;
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
     
        
        
}
