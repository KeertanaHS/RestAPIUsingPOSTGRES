/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.resto.controller;

/**
 *
 *Keertana H S 
 */
public class UriInfo {
    public static final String CREATE_USER = "rest/user/register";
    public static final String LOGIN_USER = "rest/user/login";
    public static final String UPDATE_USER = "rest/user/update";
    public static final String DELETE_USER = "rest/user/delete/{userId}";
    public static final String GET_USER_BY_ID = "rest/user/{userId}";
    public static final String GET_USER_BY_EMAIL = "rest/user/get/{emailId}";
  
    
}
