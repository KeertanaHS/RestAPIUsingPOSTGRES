package com.resto.dao;



import com.resto.model.Ingrediant;
import com.resto.model.Recipe;
import com.resto.model.ResetPassword;
import com.resto.model.Unit;
import com.resto.model.User;
import com.resto.model.Veter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Keertana H S
*/

public class DAOClass {
	
    public boolean userRegistration( User user){
        boolean flag = false;
        Connection conn = null;
        try {
            String insertUser = "INSERT INTO \"Unhoven\".user_master(usr_unique_id, email, mobile, first_name, last_name, "
                    + "address1, address2, city, state, country, usr_password) VALUES "
                    + "( 'USR"+System.currentTimeMillis()+"', '"+user.getEmail()+"', '"+user.getMobile()+"', '"+user.getFirstName()+"', "
                    + " '"+user.getLastName()+"', '"+user.getAddr1()+"', '"+user.getAddr2()+"', '"+user.getCity()+"', '"+user.getState()+"', "
                    + "  '"+user.getCountry()+"', '"+user.getPassword()+"')";
            System.out.println("insertUser <<<<<<<<<<<<<  : " +insertUser);
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertUser);
            int i = pstmt.executeUpdate();
            if(i > 0){
                flag = true;
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         DBClass.clossConnection(conn);
        }
        return flag;
	}
    
    public Map<String, Object> login(User userDetails) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
            try {
                
             String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE email = '"+userDetails.getEmail()+"' AND usr_password = '"+userDetails.getPassword()+"'";
                System.out.println(">>>>>>>>>>>>>  "+loginQuery);
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		
		return returnMap;
	}

	public boolean checkUserExist(User userDetails) {
            Connection conn = null;
            boolean flag = false;
            try {
            String checkQuery = "SELECT COUNT(ID) cnt FROM \"Unhoven\".user_master WHERE email = '"+userDetails.getEmail()+"' ";;
            conn = DBClass.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(checkQuery);
                ResultSet rs = pstmt.executeQuery();
                int cnt = 0;
                
                while(rs.next()){
                    cnt = rs.getInt("cnt");
                }
                if(cnt > 0){
                    flag = true;
                }else{
                   flag = false; 
                }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return flag;
	}
        
        public String updateUser(User userDetails) {
            String returnString = "failed";
            Connection conn = null;
           try {
            String updateUser = "UPDATE \"Unhoven\".user_master "
                    + "SET   first_name='"+userDetails.getFirstName()+"', last_name='"+userDetails.getLastName()+"', "
                    + "address1='"+userDetails.getAddr1()+"', address2='"+userDetails.getAddr2()+"', city='"+userDetails.getCity()+"', "
                    + "state='"+userDetails.getState()+"', country='"+userDetails.getCountry()+"' "
                    + "WHERE id= "+userDetails.getId()+"";
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(updateUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString =  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnString;
	}

	public String deleteUser(String userId) {
            String returnString = "failed";
            Connection conn = null;
            try {
            String deleteUser = "DELETE FROM \"Unhoven\".user_master " 
                            +" WHERE id = '"+userId+"'";
            conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(deleteUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString=  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
          return returnString;
	}

	public Map<String, Object> getUser(String emailId) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
            conn = DBClass.getConnection();
            String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE email = '"+emailId+"' ";
                System.out.println("getUserByEmail Query>>>>>>>>>>>>>  "+loginQuery);
            
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
	
	public Map<String, Object> getUserById(String userId) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
            conn = DBClass.getConnection();
            String loginQuery = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".user_master "
                    + "WHERE id = "+userId+" ";
                System.out.println("getUserById Query>>>>>>>>>>>>>  "+loginQuery);
            
            PreparedStatement pstmt = conn.prepareStatement(loginQuery);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            int i = 0;
            
            while(rs.next()){
                user.setId(rs.getInt("id")+"");
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setMobile(rs.getString("mobile"));
                user.setUniqueId(rs.getString("usr_unique_id"));
                user.setAddr1(rs.getString("address1"));
                user.setAddr2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("userData", user);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
        
        /**
         * 
         * 
         * 
         * 
         * 
         * 
         */
        
    public String addRecipes( Recipe recipe, String uniqueId){
        Connection conn = null;
        String returnString = "0";
        try {
            
            String insertReciepe = "INSERT INTO \"Unhoven\".recipe_master(" 
                    + " r_unique_id, r_name, r_image_url, price, unit_id, r_description, " 
                    + " poster_id) VALUES "
                    + "( '"+uniqueId+"', '"+recipe.getRecipeName()+"', '"+recipe.getRecipeImageUrl()+"', '"+recipe.getRecipePricePerUnit()+"', "
                    + "  '"+recipe.getRecipeUnitId()+"', '"+recipe.getRecipeDescription()+"', '"+recipe.getRecipePosterId()+"' )";
             System.out.println("insertReciepe Query>>>>>>>>>>>>>  "+ insertReciepe);
             conn = DBClass.getConnection();
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(insertReciepe, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                returnString = rs.getLong(1)+"";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		 
		return returnString;
	}
    
    public String addRecipeUnit( Unit unit){
        Connection conn = null;
        String returnString = "failed";
        try {
           
            String addUnit = "INSERT INTO \"Unhoven\".unit_master( " 
                    + " unit_name) " 
                    + "    VALUES ( '"+unit.getUnitName()+"')";
            System.out.println("addUnit Query>>>>>>>>>>>>>  "+ addUnit);
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addUnit);
            int i = pstmt.executeUpdate();
            if(i > 0){
                returnString = "success";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		 
		return returnString;
	}

     public int addIngerdiant( Ingrediant ingrediant, String recipeId){
         Connection conn = null;
         int i = 0;
        try {
           
            String addIngrediant = "INSERT INTO \"Unhoven\".ingredients_details( " 
                    + " recipe_fk_id, ingredient_name) " 
                    + "    VALUES ( '"+recipeId+"', '"+ingrediant.getIngredientName()+"')";
            System.out.println("addIngrediant Query>>>>>>>>>>>>>  "+ addIngrediant);
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addIngrediant);
            i = pstmt.executeUpdate();
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		 
		return i;
	}
    
	public List<Recipe> getRecipes() {
            Connection conn = null;
           List<Recipe> recipeList = new ArrayList<Recipe>();
            try {
            String selectquery = "SELECT rm.id, r_unique_id, r_name, r_image_url, price, unit_name, r_description, "
                    + " poster_id  FROM \"Unhoven\".recipe_master rm, \"Unhoven\".unit_master um WHERE um.id = rm.unit_id ";
            System.out.println("getRecipes:selectquery Query>>>>>>>>>>>>>  "+ selectquery);
            
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(selectquery);
            ResultSet rs = pstmt.executeQuery();
                Recipe recipe = null;
                
            while(rs.next()){
                recipe = new Recipe();
                String id = rs.getString("id");
                recipe.setId(id);
                recipe.setRecipeId(id);
                recipe.setRecipeName(rs.getString("r_name"));
                recipe.setRecipeUnitId(rs.getString("r_unique_id"));
                recipe.setRecipeImageUrl(rs.getString("r_image_url"));
                recipe.setRecipePricePerUnit(rs.getString("price"));
                recipe.setRecipeUnitId(rs.getString("unit_name"));
                recipe.setRecipeDescription(rs.getString("r_description"));
                recipe.setRecipePosterId(rs.getString("poster_id"));
               List<Ingrediant>ingredList =  getIngrediants(id);
               recipe.setIngrediantList(ingredList);
               recipeList.add(recipe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return recipeList;
	}
        
        private List<Ingrediant> getIngrediants(String recipeid) {
            Connection conn = null;
            List<Ingrediant> ingrediantList = new ArrayList<Ingrediant>();
            try {
            String selectquery = "SELECT id, recipe_fk_id, ingredient_name " 
                    + "  FROM \"Unhoven\".ingredients_details  WHERE recipe_fk_id = '"+recipeid+"'";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(selectquery);
            ResultSet rs = pstmt.executeQuery();
                Ingrediant ingrediant = new Ingrediant();
                
            while(rs.next()){
                ingrediant = new Ingrediant();
                ingrediant.setId(rs.getString("id"));
                ingrediant.setIngredientName(rs.getString("ingredient_name"));
                ingrediantList.add(ingrediant);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return ingrediantList;
	}

	public String updateRecipePrice(Recipe recipe) {
            Connection conn = null;
            String returnString = "failed";
            try {
            String updatePrice = "UPDATE \"Unhoven\".recipe_master SET  price='"+recipe.getRecipePricePerUnit()+"' "
                    + " WHERE id= '"+recipe.getId()+"'";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(updatePrice);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
		returnString =  "success";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
	return returnString;
	}

	public String deleteRecipe(String recipeId) {
            Connection conn = null;
           String returnString = "failed";
            try {
            String deleteIngrediant = "DELETE FROM \"Unhoven\".ingredients_details WHERE recipe_fk_id= '"+recipeId+"'";    
            String deleteRecipe = "DELETE FROM \"Unhoven\".recipe_master WHERE id= '"+recipeId+"'";
             conn = DBClass.getConnection();
            PreparedStatement pstmt1 = conn.prepareStatement(deleteIngrediant);
            pstmt1.executeUpdate();
            PreparedStatement pstmt = conn.prepareStatement(deleteRecipe);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
		returnString =  "success";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
	return returnString;
	}

	
        
  
        public boolean veterRegistration( Veter veter){
        boolean flag = false;
        Connection conn = null;
        try {
            String insertUser = "INSERT INTO \"Unhoven\".veter_master( mobile, first_name, last_name, city, country) VALUES "
                    + " ( '"+veter.getMobile()+"', '"+veter.getFirstName()+"', '"+veter.getLastName()+"', '"+veter.getCity()+"', '"+veter.getCountry()+"')";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertUser);
            int i = pstmt.executeUpdate();
            if(i > 0){
                flag = true;
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         DBClass.clossConnection(conn);
        }
        return flag;
	}
    
        public String updateVeter(Veter veter) {
            Connection conn = null;
            String returnString = "failed";
           try {
            String updateUser = "UPDATE \"Unhoven\".veter_master "
                    + "SET   first_name='"+veter.getFirstName()+"', last_name='"+veter.getLastName()+"', "
                    + " city='"+veter.getCity()+"', country='"+veter.getCountry()+"' "
                    + "WHERE id= "+veter.getId()+"";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(updateUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString =  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnString;
	}

	public String deleteVeter(String userId) {
            String returnString = "failed";
            Connection conn = null;
            try {
            String deleteUser = "DELETE FROM \"Unhoven\".veter_master " 
                            +" WHERE id = '"+userId+"'";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(deleteUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString=  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
          return returnString;
	}

	public Map<String, Object> getVeters() {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
             conn = DBClass.getConnection();
            String getveterList = "SELECT id, usr_unique_id, email, mobile, first_name, last_name, address1, address2, city, state, "
                    + "country, usr_password FROM \"Unhoven\".veter_master ";
                System.out.println("getveterList Query>>>>>>>>>>>>>  "+getveterList);
            
            PreparedStatement pstmt = conn.prepareStatement(getveterList);
            ResultSet rs = pstmt.executeQuery();
            Veter veter = new Veter();
            int i = 0;
            List<Veter> veterList = new ArrayList<Veter>();
            while(rs.next()){
                veter = new Veter();
                veter.setId(rs.getInt("id")+"");
                veter.setFirstName(rs.getString("first_name"));
                veter.setLastName(rs.getString("last_name"));
                veter.setMobile(rs.getString("mobile"));
                veter.setCity(rs.getString("city"));
                veter.setCountry(rs.getString("country"));
                i++;
                veterList.add(veter);
            }
            
            returnMap.put("veterData", veter);
            returnMap.put("totalVeterCount", i);
            
            if(i>0){
                returnMap.put("success", true);
                
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
	
	public Map<String, Object> getVeterById(String veterId) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Connection conn = null;
           try {
            
             conn = DBClass.getConnection();
            String getVeterById = "SELECT id, mobile, first_name, last_name,city, "
                    + "country, usr_password FROM \"Unhoven\".veter_master WHERE id = "+veterId+" ";
                System.out.println("getVeterById Query>>>>>>>>>>>>>  "+getVeterById);
            
            PreparedStatement pstmt = conn.prepareStatement(getVeterById);
            ResultSet rs = pstmt.executeQuery();
            Veter veter = new Veter();
            int i = 0;
            
            while(rs.next()){
                veter.setId(rs.getInt("id")+"");
                veter.setFirstName(rs.getString("first_name"));
                veter.setLastName(rs.getString("last_name"));
                veter.setMobile(rs.getString("mobile"));
                veter.setCity(rs.getString("city"));
                veter.setCountry(rs.getString("country"));
                i++;
            }
            returnMap.put("veterData", veter);
            if(i>0){
                returnMap.put("success", true);
            }else{
                returnMap.put("success", false);
            }
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnMap;
	}
        
        
        public String resetPassword(ResetPassword resetPass) {
            String returnString = "failed";
            Connection conn = null;
           try {
            String updateUser = "UPDATE \"Unhoven\".user_master "
                    + "SET   usr_password='"+resetPass.getNewPassword()+"' "
                   + "WHERE id = '"+resetPass.getUserid()+"' AND usr_password= '"+resetPass.getOldPassword()+"' ";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(updateUser);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString =  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnString;
	}

        
        public String addFavouriteRecipe(String userId, String recipeId) {
            String returnString = "failed";
            Connection conn = null;
           try {
            String addFeverate = "INSERT INTO \"Unhoven\".user_favourite_recipe_mapping( user_fk_id, recipe_fk_id) "
                    + "VALUES ('"+userId+"', '"+recipeId+"')";
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addFeverate);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString =  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return returnString;
	}

	public String deleteFavouriteRecipe(String userFavouriteRecipeId) {
            String returnString = "failed";
            Connection conn = null;
            try {
            String deleteFavouriteRecipeid = "DELETE FROM \"Unhoven\".user_favourite_recipe_mapping " 
                            +" WHERE id = '"+userFavouriteRecipeId+"'";
                System.out.println("deleteFavouriteRecipeid<<<<<<<<<<<  : "+deleteFavouriteRecipeid);
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(deleteFavouriteRecipeid);
            int i = pstmt.executeUpdate();
            if( i > 0)
		{
			returnString = "success";
		}else{
		returnString=  "failed";
		}
            //jdbcTemplate.q
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
          return returnString;
	}
        
        public List<Recipe> getFevouriteRecipes(String userId) {
           List<Recipe> recipeList = new ArrayList<Recipe>();
           Connection conn = null;
            try {
            String selectquery = "SELECT rm.id, r_unique_id, r_name, r_image_url, price, unit_name, r_description, "
                    + " poster_id  FROM \"Unhoven\".recipe_master rm, \"Unhoven\".unit_master um WHERE "
                    + " rm.id IN (SELECT DISTINCT(recipe_fk_id) FROM \"Unhoven\".user_favourite_recipe_mapping WHERE user_fk_id = '"+userId+"') "
                    + " AND um.id = rm.unit_id";
            System.out.println("getFevouriteRecipes:selectquery Query>>>>>>>>>>>>>  "+ selectquery);
            
             conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(selectquery);
            ResultSet rs = pstmt.executeQuery();
                Recipe recipe = null;
                
            while(rs.next()){
                recipe = new Recipe();
                String id = rs.getString("id");
                recipe.setId(id);
                recipe.setRecipeId(id);
                recipe.setRecipeName(rs.getString("r_name"));
                recipe.setRecipeUnitId(rs.getString("r_unique_id"));
                recipe.setRecipeImageUrl(rs.getString("r_image_url"));
                recipe.setRecipePricePerUnit(rs.getString("price"));
                recipe.setRecipeUnitId(rs.getString("unit_name"));
                recipe.setRecipeDescription(rs.getString("r_description"));
                recipe.setRecipePosterId(rs.getString("poster_id"));
               List<Ingrediant>ingredList =  getIngrediants(id);
               recipe.setIngrediantList(ingredList);
               recipeList.add(recipe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         DBClass.clossConnection(conn);
        }
		
		return recipeList;
	}

}
