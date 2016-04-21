/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.resto.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Keertana H S
 *
 */
@XmlRootElement
public class Recipe implements Serializable{
    
    private String id;
    private String recipeId;
    private String recipeName;
    private String recipeImageUrl;
    private String recipePricePerUnit;
    private String recipeUnitId;
    private String recipeDescription;
    private String recipePosterId;
    private List<Ingrediant> ingrediantList;

    public Recipe(String id, String recipeId, String recipeName, String recipeImageUrl, String recipePricePerUnit, 
            String recipeUnitId, String recipeDescription, String recipePosterId, List<Ingrediant> ingrediantList) {
       this.id = id;
       this.recipeName = recipeName;
       this.recipeImageUrl = recipeImageUrl;
       this.recipePricePerUnit = recipePricePerUnit;
       this.recipeUnitId = recipeUnitId;
       this.recipeName = recipeName;
       this.recipeDescription = recipeDescription;
       this.recipePosterId = recipePosterId;
       this.ingrediantList = ingrediantList;
       
    }

    public Recipe() {
        
    }

    public Recipe(String id, String recipePricePerUnit) {
         this.id = id;
       this.recipePricePerUnit = recipePricePerUnit;
       
    }

    public Recipe(String recipeId, String recipeName, String recipeImageUrl, String recipePricePerUnit, String recipeUnitId, String recipeDescription, String recipePosterId, List<Ingrediant> ingrediantList) {
        
       this.recipeName = recipeName;
       this.recipeImageUrl = recipeImageUrl;
       this.recipePricePerUnit = recipePricePerUnit;
       this.recipeUnitId = recipeUnitId;
       this.recipeName = recipeName;
       this.recipeDescription = recipeDescription;
       this.recipePosterId = recipePosterId;
       this.ingrediantList = ingrediantList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }

    public void setRecipeImageUrl(String recipeImageUrl) {
        this.recipeImageUrl = recipeImageUrl;
    }

    public String getRecipePricePerUnit() {
        return recipePricePerUnit;
    }

    public void setRecipePricePerUnit(String recipePricePerUnit) {
        this.recipePricePerUnit = recipePricePerUnit;
    }

    public String getRecipeUnitId() {
        return recipeUnitId;
    }

    public void setRecipeUnitId(String recipeUnitId) {
        this.recipeUnitId = recipeUnitId;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getRecipePosterId() {
        return recipePosterId;
    }

    public void setRecipePosterId(String recipePosterId) {
        this.recipePosterId = recipePosterId;
    }

    public List<Ingrediant> getIngrediantList() {
        return ingrediantList;
    }

    public void setIngrediantList(List<Ingrediant> ingrediantList) {
        this.ingrediantList = ingrediantList;
    }

   
}
