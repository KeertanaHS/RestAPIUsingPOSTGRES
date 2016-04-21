/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.resto.model;


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Keertana H S
 * 
 */
@XmlRootElement
public class Ingrediant implements Serializable{
   private String ingredientName;
   private String id;
   private String recipeid;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(String recipeid) {
        this.recipeid = recipeid;
    }
    
    
    
}
