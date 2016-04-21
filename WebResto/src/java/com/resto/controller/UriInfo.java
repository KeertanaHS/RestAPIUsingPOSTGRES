/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.resto.controller;

/**
 *
 * Keertana H S
 */
public class UriInfo {
    public static final String CREATE_USER = "rest/user/register";
    public static final String LOGIN_USER = "rest/user/login";
    public static final String UPDATE_USER = "rest/user/update";
    public static final String DELETE_USER = "rest/user/delete/{userId}";
    public static final String GET_USER_BY_ID = "rest/user/{userId}";
    public static final String GET_USER_BY_EMAIL = "rest/user/get/{emailId}";
    
    public static final String RESET_PASSWORD = "rest/user/reset";
    
    public static final String USER_FAVOURITE_RECIPE_ADD = "rest/user/add/favourite/{userId}/{recipeId}";
    public static final String USER_FAVOURITE_RECIPE_DELET = "rest/user/delete/favourite/{userFavouriteRecipeId}";
    public static final String GET_USER_FAVOURITE_RECIPE = "rest/user/favourite/{userId}";
    
    public static final String CREATE_RECIPE = "rest/recipe/add";
    public static final String GET_RECIPES = "rest/recipes";
    public static final String UPDATE_RECIPE = "rest/recipe/update/{recipeId}";
    public static final String DELETE_RECIPE = "rest/recipe/delete/{recipeId}";  
    public static final String GET_RECIPE_BY_ID = "rest/recipe/{recipeId}";
    public static final String CREATE_UNIT = "rest/unit/add";
   // public static final String DELETE_EMP = "rest/emp/delete/{id}";
    public static final String CREATE_VETER = "rest/user/veter/add";
    public static final String UPDATE_VETER = "rest/user/veter/update";
    public static final String DELETE_VETER = "rest/user/veter/delete/{veterId}";
    public static final String GET_VETER = "rest/user/veters";
    public static final String GET_VETER_BY_ID = "rest/user/veter/{veterId}";

    
}
