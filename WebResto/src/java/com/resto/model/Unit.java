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
public class Unit implements Serializable{
    private String id;
    private String unitName;

    public Unit(String id, String unitName) {
         this.id = id;
       this.unitName = unitName;
      
    }

    public Unit(String unitName) {
         this.unitName = unitName;
    }
    
     public Unit() {
         
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    
}
