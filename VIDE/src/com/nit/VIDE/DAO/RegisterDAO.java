package com.nit.VIDE.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nit.VIDE.Bean.RegisterForm;
import com.nit.VIDE.util.AbstractDataAccessObject;






import com.nit.VIDE.util.DateWrapper;

public class RegisterDAO  extends AbstractDataAccessObject {
	public RegisterDAO()
	{
		System.out.println("in register dao ............");
	}

	Connection con;
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs;
	ResultSet rs1;
	
	
	 public boolean insertNewUser(RegisterForm  cp) throws FileNotFoundException
	    
	    {
	    	boolean flag=true;
	    	int insert=0;	    	
	    	try{	    		
	    		con=getConnection();
		    	System.out.println("in registerDAO connection is ."+con);	          	
	            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,'user',?,?,?,?,?,?)");	            		    		
	    		System.out.println();
	    		String photo =cp.getPhoto();
	    		
	    		String dob=DateWrapper.parseDate(cp.getDob());
	    		System.out.println(" in dao dob"+dob);
	    		
	    		
	    		String fname=cp.getFname();
	    		String lname=cp.getLname();
	    		String squestion=cp.getQuestn();
	    		String ans=cp.getAnsr();
	    		String email=cp.getEmail();
	    		String phone=cp.getMobile();
	    		String fax=cp.getFax();
	    		
	    		String loginid=cp.getUserid();
	    		String pwd=cp.getUserpwd();	    			    		
	    		String hno=cp.getHno();
	    		String street=cp.getStreet();
	    		String city=cp.getCity();
	    		String state=cp.getState();
	    		String country=cp.getCountry();
	    		String pin=cp.getPin();	    		
	    		System.out.println("photo="+photo);
	        	File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
	        	System.out.println("fole="+f.length());	        	
	        	    		        	
	            pstmt.setString(1, fname);
	            pstmt.setString(2, lname);
	            pstmt.setString(3, dob);
	            pstmt.setString(4, loginid);
	            pstmt.setString(5, pwd);
	          
	            pstmt.setString(6, squestion);
	            pstmt.setString(7, ans);
	            
	          pstmt.setBinaryStream(8, fis,(int)f.length());
	        
	          pstmt.setString(9, email);
	          pstmt.setString(10, fax);
	          pstmt.setString(11, phone);
	      
	          int i=pstmt.executeUpdate();
	          
	          if(i>0)
	          {	        	  
	        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),(select nvl(max(addressid),1000)+1 from addresses),?,?,?,?,?,?)");	        	  	        	  
	        	  pstmt1.setString(1, hno);
	        	  pstmt1.setString(2, street);
	        	  pstmt1.setString(3, city);
	        	  pstmt1.setString(4, state);
	        	  pstmt1.setString(5, country);
	        	  pstmt1.setString(6,pin);	        	  	        	  
	        	  insert=pstmt1.executeUpdate();
	        	  }	          	          
	          if(insert>0)
		         {
		         
		          con.commit();
		         }
		         else
		         {
		        	 flag=false;
		        	 con.rollback();
		         }
		    } 
		    catch (Exception e) 
		    {
		        e.printStackTrace();
		        flag=false;
		        try 
		        {
		            con.rollback();
		        } 
		        catch (SQLException se) 
		        {
		            se.printStackTrace();
		        }
		    }
		    
		    finally
			{
			 try{
				 if(con!=null)
					 con.close();				 
			 }
			 catch(Exception e){}
			}
		return flag;
	}
	 
	 
	 
	 public void logout1(String user){
	    	
	    	
	    	try{
	    		pstmt=con.prepareStatement("update loginmaster set logofftime=sysdate where userid=? and logofftime is null");
	    		pstmt.setString(1, user);
	    		int c=pstmt.executeUpdate();
	    		if(c>0){
	     			con.commit();
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    }
	 public boolean logout(String loginid)
	    {
		 
		 boolean flag=true;
	        try 
	        { con=getConnection();
	        int uid=0;
	      
	        System.out.println("in logout Dao login id is........."+loginid);
	        	
	            pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
	            pstmt.setString(1,loginid);
	            rs=pstmt.executeQuery();
	            if(rs.next())
	            	
	            	uid=rs.getInt(1);
	            
	            System.out.println("in logout method");
	           
	            pstmt1=con.prepareStatement( "update loginmaster set logofftime=sysdate where logofftime is null and userid=?");
	            pstmt1.setInt(1, uid);
	            
	            int update=pstmt1.executeUpdate();

				if(update>0)
		         {
		         
		          con.commit();
		         }
		         else
		         {
		        	 flag=false;
		        	 con.rollback();
		         }

		    } 
		    
		    catch (Exception e) 
		    {
		        e.printStackTrace();
		        flag=false;
		        try 
		        {
		            con.rollback();
		        } 
		        catch (SQLException se) 
		        {
		            se.printStackTrace();
		        }
		    }
		    
		    finally
			{
			 try{
				 if(con!=null)
					 con.close();				 
			 }
			 catch(Exception e){}
			}
		return flag;
	}
	 
	 public String passwordRecovery(){
	    	String password="";
	        try{
	        	  con=getConnection();
	        	 String question="";
				 String ans="";
				 String loginid="";
				
	        	pstmt=con.prepareStatement("select password from userdetails where loginid=? and forgotpwquestion=? and forgotpwanswer=?");
	        	pstmt.setString(1, loginid);
	        	pstmt.setString(2, question);
	        	pstmt.setString(3, ans);
	        	rs=pstmt.executeQuery();
	        	if(rs.next()){
	        		password=rs.getString(1);
	        	}
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	    	return password;
	    }
	 
	 
	 public boolean checkAvailability(String userid){
	    	boolean flag=true;
	    	
	    	System.out.println("in DAo Calsss userid.........."+userid);
	    	try{
	    		con=getConnection();
	    		pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
	    		pstmt.setString(1, userid);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			
	    			int uid=rs.getInt(1);
	    			System.out.println("in DAo uid=========="+uid);
	    			flag=false;
	    		}
	    	}catch(Exception e){
	    		
	    	}
	    	return flag;
	    }
	    
	 
	 public boolean changePass(){
	    	boolean flag=false;
	    	try{
	    		
	    		con=getConnection();
	    		
	    		String newpass="";
	    		String user="";
	    		
	    		pstmt=con.prepareStatement("update userdetails set password=? where loginid=?");
	    		pstmt.setString(1, newpass);
	    		pstmt.setString(2, user);
	    		int c=pstmt.executeUpdate();
	    		if(c>0){
	    			flag=true;
	    			con.commit();
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return flag;
	    }
	 
	 
	 
	 public boolean changeQuestion()
	 {
		 boolean flag=true;
		 
		 try{
			 
			 
			 con=getConnection();
			 
			 String question="";
			 System.out.println("in Dao qusetion is..."+question);
			 String ans="";
			 System.out.println("in Dao ans is..."+ans);
			 String loginid="";
			 System.out.println("in Dao loginid is..."+loginid);
			 String pwd="";
			 System.out.println("in Dao pwd is..."+pwd);
			 
			 pstmt=con.prepareStatement("update userdetails set forgotpwquestion=?,forgotpwanswer=? where loginid=? and password=?");
			 pstmt.setString(1, question);
			 pstmt.setString(2, ans);
			 pstmt.setString(3, loginid);
			 pstmt.setString(4, pwd);
			 
			 int update=pstmt.executeUpdate();
			 
			 
			 if(update>0)
	         {
	         
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }

	    } 
	    
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){}
		}
	return flag;
}
}
