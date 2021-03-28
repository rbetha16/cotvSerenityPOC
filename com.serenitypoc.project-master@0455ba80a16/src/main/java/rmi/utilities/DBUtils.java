package rmi.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class DBUtils {	
	
	 
	public static String executeSQLQuery(String sqlQuery)
	{
		//int rows = 0;
		String queryResultValue= "";
		
	
	try {
        		
        	Class.forName(ProjectVariables.DB_DRIVER_NAME);
        	Connection con = DriverManager.getConnection(ProjectVariables.DB_CONNECTION_URL,ProjectVariables.DB_USERNAME,ProjectVariables.DB_PASSWORD);
        	
        	  if(con!=null) {
                  System.out.println("Connected to the Database...");
              }else {
                  System.out.println("Database connection failed ");
              }
        	
        	  Statement st = con.createStatement();	        		
        	  ResultSet rs =st.executeQuery(sqlQuery);        	

            while(rs.next())
            {
               queryResultValue = rs.getString(1).toString();         
            } 
            
            System.out.println("DB Result: "+queryResultValue);
            
            con.close();
            
        }catch (SQLException e) {
            e.printStackTrace();}
        
        catch (NullPointerException err) {
            System.out.println("No Records obtained for this specific query");
            err.printStackTrace();              }        
		
	     catch (ClassNotFoundException e1) {     		  		
				e1.printStackTrace();	}
       
	 
	 return queryResultValue;
        
	}   
	
	

	public static  ArrayList<String> executeSQLQueryMultipleRows(String sqlQuery)
	{
		//int rows = 0;
		//String queryResultValue= "";
		ArrayList<String> resultList = new ArrayList<String>();
	
	try {
        		
        	Class.forName(ProjectVariables.DB_DRIVER_NAME);
        	Connection con = DriverManager.getConnection(ProjectVariables.DB_CONNECTION_URL,ProjectVariables.DB_USERNAME,ProjectVariables.DB_PASSWORD);
        	
        	  if(con!=null) {
                  System.out.println("Connected to the Database...");
              }else {
                  System.out.println("Database connection failed ");
              }
        	
        	  
        	 String result;
        	  
        	  Statement st = con.createStatement();	        		
        	  ResultSet rs =st.executeQuery(sqlQuery);  
        	  
        	 
        	  while (rs.next()) {
        	          result = rs.getString(1).toString();
        	          resultList.add(result);
        	      }
        	
        	           
            //System.out.println("DB Result: "+queryResultValue);
            
            con.close();
            
        }catch (SQLException e) {
            e.printStackTrace();}
        
        catch (NullPointerException err) {
            System.out.println("No Records obtained for this specific query");
            err.printStackTrace();              }        
		
	     catch (ClassNotFoundException e1) {     		  		
				e1.printStackTrace();	}
       
	 
	  return resultList;
          
	}   
	
public static String GET_VALID_VALUE_IN_DB(String first,String second){
		
		String sQuery = "select ICD_CODE from MDM_STAGE.DX_MAP_STAGE where rownum < "+first+" minus select ICD_CODE from MDM_STAGE.DX_MAP_STAGE where rownum < "+second;
		 
		
		String sResult = executeSQLQuery(sQuery);
		System.out.println("sResult++++++++++++++++++++"+sResult);
		
		if(!(sResult.equals(" "))){
			System.out.println(" is  Successfully updated in the DataBase");
		}else{
			System.out.println("is not Successfully updated in the DataBase");
			
		}
		
		return sResult;
	}
	
	
	
	
	         
	}

        

