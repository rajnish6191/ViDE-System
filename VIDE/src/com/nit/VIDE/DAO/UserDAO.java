package com.nit.VIDE.DAO;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.io.OutputStream;

import com.nit.VIDE.util.CoreList;
import com.nit.VIDE.util.LoggerManager;
import com.nit.VIDE.Bean.RegisterForm;
import com.nit.VIDE.util.AbstractDataAccessObject;


public class UserDAO extends AbstractDataAccessObject{
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	public UserDAO()
	{
		con=getConnection();
		
	}
	
	
	
	
	public CoreList getEmpDetails(String path)
    {
    	CoreList aCoreList = new CoreList();
    	Connection con=null; 
    	String userid="";
    	String ctitle="";
    	RegisterForm rb=null;
		aCoreList.clear();
		Statement st;
		try {
			con = getConnection();
			st = con.createStatement();
			int count = 0;
			ResultSet rs = st.executeQuery("select USERID,LOGINTYPE,firstname,lastname,to_char(dob),emailid,faxno,photograph,phoneno from userdetails where logintype!='admin'");
			while(rs.next())
			{
				
				rb=new RegisterForm();
				userid=rs.getString(1);
				//inventory.setBrandID(rs.getInt(1));
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
				rb.setFax(rs.getString(7));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				
				rb.setMobile(rs.getString(9));
				
				count++;
				
		          aCoreList.add(rb);
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return aCoreList;
    }  
		
	public CoreList getUsers(String path)
    {
    	CoreList aCoreList = new CoreList();
    	Connection con=null; 
    	String userid="";
    	String ctitle="";
    	RegisterForm rb=null;
		aCoreList.clear();
		Statement st;
		try {
			con = getConnection();
			st = con.createStatement();
			int count = 0;
			ResultSet rs = st.executeQuery("select USERID,LOGINTYPE,firstname,lastname,to_char(dob),emailid,faxno,photograph,phoneno from userdetails where logintype!='admin'");
			while(rs.next())
			{
				
				rb=new RegisterForm();
				userid=rs.getString(1);
				//inventory.setBrandID(rs.getInt(1));
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
				rb.setFax(rs.getString(7));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				
				rb.setMobile(rs.getString(9));
				
				
				
				count++;
				aCoreList.add(rb);
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return aCoreList;
    }  
		
		
	
		
	}
	

