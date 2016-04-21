/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.resto.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Keertana H S 
 */
@XmlRootElement
public class Veter implements Serializable{

	private String id;
	private String mobile;
	private String firstName;
	private String lastName;
	private String city;
	private String country;
        
        private static final long serialVersionUID = -7788619177798333712L;

    public Veter(String id, String mobile, String firstName, String lastName, String city, String country) {
        this.id = id;
       this.mobile = mobile;
       this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
    }

    public Veter() {
       
    }

    public Veter(String mobile, String firstName, String lastName, String city, String country) {
         this.mobile = mobile;
       this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}
