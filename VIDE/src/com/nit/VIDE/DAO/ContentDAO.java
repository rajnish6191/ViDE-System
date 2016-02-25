package com.nit.VIDE.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import com.nit.VIDE.Bean.ContentBean;
import com.nit.VIDE.Bean.SearchBean;
import com.nit.VIDE.Bean.form1;
import com.nit.VIDE.util.AbstractDataAccessObject;
import com.nit.VIDE.util.DateWrapper;

public class ContentDAO extends AbstractDataAccessObject{
	
	
	static int count=0;
	static int i=0;
     Connection con;
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
	Statement stmt,stmt1,stmt2;
	ResultSet rs,rs1,rs2,rs3;
	
	
	public ContentDAO()
	{
		
		con=getConnection();
		
	}
	
	
	public boolean addContent(ContentBean cb, String login)
	{
		boolean flag=true;
		
		int uid=0;
		
		
		try{
			
			pstmt=con.prepareStatement("insert into content values((select nvl(max(cid),100)+1 from content),?,?,?,?,?,?,?,(select sysdate from dual),?,?,?)");
			
			
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
			if(rs1.next())
			{
				
				 uid=rs1.getInt(1);
				 
				 System.out.println("in DAo from userdetails uid is..............."+uid);
			}
			
			
			
			pstmt.setString(1, cb.getCname());
			pstmt.setString(2, cb.getCsubname());
			pstmt.setString(3, cb.getDescription());
			pstmt.setString(4, cb.getCatagery());
			pstmt.setString(5, cb.getTopic());
			
			
			String image=cb.getImage();
			
			
			File file=new File(image);
			  FileInputStream fis=new FileInputStream(file);
			  pstmt.setBinaryStream(6,fis ,(int)file.length());
			  
			  String content=cb.getContent();
			  
			  
			  File f1=new File(content);
			  FileInputStream fs=new FileInputStream(f1);
			  
			  pstmt.setBinaryStream(7, fs, (int)f1.length());
			  pstmt.setDouble(8, cb.getPrice());
			  pstmt.setString(9, cb.getCtype());
			  
			  pstmt.setInt(10, uid);
			  
		
			
			
			int insert=pstmt.executeUpdate();
			
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
	
	
	
	
	public Vector<ContentBean> getContent(String path)
	{
		
		
		Vector<ContentBean> vcb=null;
		
		try{
			
			
			pstmt=con.prepareStatement("select *from content");
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ContentBean cb=new ContentBean();
				
				int cid=rs.getInt(1);
				
				cb.setCid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setCsubname(rs.getString(3));
				cb.setDescription(rs.getString(4));
				cb.setCatagery(rs.getString(5));
				cb.setTopic(rs.getString(6));
				
				
				Blob b=rs.getBlob(7);
				  byte b1[]=b.getBytes(1,(int)b.length());
				   
				  OutputStream fout=new FileOutputStream(path+"/"+cid+ ".jpg");
				 // System.out.println(fout+"*********************");
				    fout.write(b1);
				
				cb.setImage(".jpg");
				
				
				Blob bb=rs.getBlob(8);
				  byte b2[]=b.getBytes(1,(int)bb.length());
				   
				  OutputStream fout1=new FileOutputStream(path+"/"+cid+ ".doc");
				 // System.out.println(fout+"*********************");
				    fout1.write(b2);
				
				
				
				cb.setContent(".doc");
				
				cb.setDate(rs.getString(9));
				cb.setPrice(rs.getDouble(10));
				
				
			}
			
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return vcb;
	}
	
	public List<form1> getAllTitiles()
	{
		 List<form1> lf=null;
		 

		 
		 try{
			 
			 
			 pstmt=con.prepareStatement("select ctitle,csubtitle,cdomain from content");
			 
			 
			 rs=pstmt.executeQuery();
			 
			 lf= new ArrayList<form1>();
			 
			 while(rs.next())
			 {
				 
				 
				 
				form1 f=new form1();
				
				f.setTitle(rs.getString(1));
				f.setSubTitle(rs.getString(2));
				f.setDomain(rs.getString(3));
				
				System.out.println("in Dao from DB title is............."+rs.getString(1));
				 
				 lf.add(f);
				 
			 }
			 return lf;
			 
		}
		 catch (Exception e) {
		e.printStackTrace();
		}
		 
		 return lf;
	}
	

	
	public Vector<ContentBean> getContentAt(String path,String title,int sid,int eid,String login)
	{
		System.out.println(sid+"<-startnotitle in dao-endno->"+eid);
		
		Vector<ContentBean> vcb=null;
		String str="";
		int uid=0;
		String topic="";
		String ctype="";
		String cname="";
		String domain="";
		int sid1=0;
		
		
		try{
			
			
			StringTokenizer st=new StringTokenizer(title,"-");
			
			
		System.out.println("total token");	
			String title1=title;
			String subtitle=null;
			String query="select * from (select rownum as no,cid,ctitle,csubtitle,cdescription,ccatagery,cdomain,cimage,content,To_CHAR(uldate,'Mon dd yyyy'),price,ctype from  content where ctitle=?) where no between "+sid+" and "+eid;
		
			if(st.countTokens()==1)
			{title1=st.nextToken();
			System.out.println("only title  ->"+title1);
			query="select * from (select rownum as no,cid,ctitle,csubtitle,cdescription,ccatagery,cdomain,cimage,content,To_CHAR(uldate,'Mon dd yyyy'),price,ctype from  content where ctitle=?) where no between "+sid+" and "+eid;
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, title1);
			}
			else if(st.countTokens()==2){
				title1=st.nextToken();
				subtitle=st.nextToken();
				
				
				System.out.println(title+"<- title and subtitle-- "+subtitle);
				query="select * from (select rownum as no,cid,ctitle,csubtitle,cdescription,ccatagery,cdomain,cimage,content,To_CHAR(uldate,'Mon dd yyyy'),price,ctype from  content where csubtitle=?) where no between "+sid+" and "+eid;
				pstmt=con.prepareStatement(query);
      			pstmt.setString(1, subtitle);
				}
			else
			{
				
				
				title1=st.nextToken();
				subtitle=st.nextToken();
				domain=st.nextToken();
				
				
				
				System.out.println(title+"<- title and subtitle-- "+subtitle);
				query="select * from (select rownum as no,cid,ctitle,csubtitle,cdescription,ccatagery,cdomain,cimage,content,To_CHAR(uldate,'Mon dd yyyy'),price,ctype from  content where csubtitle=? and cdomain=?) where no between "+sid+" and "+eid;
				pstmt=con.prepareStatement(query);
      			pstmt.setString(1, subtitle);
      			pstmt.setString(2,domain );

				
			}
			System.out.println("in Action Class String is........."+title1);
			System.out.println("in Action Class String is........."+subtitle);
			
			
			
			
			
			System.out.println("IN DAO TITLE is............."+title);
			
			
			
			vcb=new Vector<ContentBean>();
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ContentBean cb=new ContentBean();
				
				int cid=rs.getInt(2);
				
				cb.setCid(cid);
				 cname=rs.getString(3);
				cb.setCname(cname);
				cb.setCsubname(rs.getString(4));
				cb.setDescription(rs.getString(5));
				cb.setCatagery(rs.getString(6));
				
				 topic=rs.getString(7);
				cb.setTopic(topic);
				
				
				Blob b=rs.getBlob(8);
				  byte b1[]=b.getBytes(1,(int)b.length());
				   
				  OutputStream fout=new FileOutputStream(path+"/"+cid+ ".jpg");
				 // System.out.println(fout+"*********************");
				    fout.write(b1);
				
				cb.setImage(cid+".jpg");
				
				
				Blob bb=rs.getBlob(9);
				  byte b2[]=bb.getBytes(1,(int)bb.length());
				   
				  OutputStream fout1=new FileOutputStream(path+"/"+cid+ ".doc");
				 // System.out.println(fout+"*********************");
				    fout1.write(b2);
				
				
				
				cb.setContent(".doc");
				
				cb.setDate(rs.getString(10));
				cb.setPrice(rs.getDouble(11));
				
				 ctype=rs.getString(12);
				cb.setCtype(ctype);
				
				
				int booksno=getBookRowCount();
				
				int musicno=getMusicRowCount();
				int mobileno=getMobileRowCount();
				
				
				
				cb.setMobileno(mobileno);
				cb.setMusicno(musicno);
				cb.setBooksno(booksno);
				
				vcb.add(cb);
				
				
			}
			
			 Date date=new Date();
             DateFormat df = new SimpleDateFormat("dd-MM-yy");
             
           String  reportDate = df.format(date); 
          
           
           String todate=DateWrapper.parseDate(reportDate);
           System.out.println("in DAo to day is.........."+todate);
			
			if(!vcb.isEmpty())
			{
				
				
				
				String ctitle="";
				String sdate="";
				
				
				stmt1=con.createStatement();
				rs1=stmt1.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
				if(rs1.next())
				{
					
					 uid=rs1.getInt(1);
					 
					 System.out.println("in DAo from userdetails uid is..............."+uid);
				}
				
				System.out.println("executing pstmt3...........in DAo");
				
				pstmt3=con.prepareStatement("select sid,content,TO_CHAR(sdate,'DD-Mon-YY') from searchinfo where userid=? and content=? and sdate like to_date(?,'dd-MON-yy') ");
				pstmt3.setInt(1, uid);
				pstmt3.setString(2, title);
				pstmt3.setString(3, todate);
				
				
				
				rs3=pstmt3.executeQuery();
				
				
				
				
				while(rs3.next())
				{
					 sid1=rs3.getInt(1);
					ctitle=rs3.getString(2);
					sdate=rs3.getString(3);
					System.out.println("in dao ctitle from search info is.........."+ctitle);
					System.out.println("in DAo title from user screen .........."+title);
					
					System.out.println("in dao date from search info is.........."+sdate);
					  System.out.println("in DAo to day is.........."+todate);
					
					
				}
				
                  
				if(title.equals(ctitle)&& todate.equals(sdate) )
				{	
					System.out.println("in DAo title from user screen .........."+title);
			
				System.out.println("in DAo count is................"+count);
				System.out.println("in DAO same");
				
				pstmt2=con.prepareStatement("update searchinfo set  scount=?,content=?,sdomain=? where userid=? and content=? and sdate like to_date(?,'dd-MON-yy')");
				
				
				
				count++;
				
				
				pstmt2.setInt(1, count);
				pstmt2.setString(2,title);
				pstmt2.setString(3, ctype);
				pstmt2.setInt(4, uid);
				pstmt2.setString(5,title);
				pstmt2.setString(6, todate);
				
				
				int update=pstmt2.executeUpdate();
				System.out.println("in DAO no of rows updated is......... "+update);
				
				}
				else
				{
					
					count=0;
					
					
				    count++;
				    System.out.println("in DAO  Not same");
				
				
				
				System.out.println("in DAO after vcb count is............"+count);
				
				pstmt1=con.prepareStatement("insert into searchinfo values((select nvl(max(sid),101)+1 from searchinfo),?,?,?,sysdate,?)");
				
				stmt1=con.createStatement();
				rs1=stmt1.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
				if(rs1.next())
				{
					
					 uid=rs1.getInt(1);
					 
					 System.out.println("in DAo from userdetails uid is..............."+uid);
				}
				
				
				pstmt1.setInt(1, uid);
				pstmt1.setString(2, title);
				pstmt1.setString(3, ctype);
				
				pstmt1.setInt(4, count);
				
			
				
				int insert=pstmt1.executeUpdate();
				
				
				
				
				
				System.out.println("in DAO  no of rows  inserted into searchinfo is........ "+insert);
				
				
				
			}
		

			}
			
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		
		return vcb;
	}
	
	
	
	
	public int getBookRowCount()
	{
		
	int pages=0;
	Statement st;
	try{
			  
			   	st=con.createStatement();
            	 ResultSet rs=st.executeQuery("select count(*) as total from content where ctype='book'");
            	if(rs.next())
                      	pages=rs.getInt("total");
                 
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		
		return pages;
	}
	
	
	
	public int getMobileRowCount()
	{
		
	int pages=0;
	Statement st;
	try{
			  
			   	st=con.createStatement();
            	 ResultSet rs=st.executeQuery("select count(*) as total from content where ctype='mobile'");
            	if(rs.next())
                      	pages=rs.getInt("total");
                 
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		
		return pages;
	}
	
	public int getMusicRowCount()
	{
		
	int pages=0;
	Statement st;
	try{
			  
			   	st=con.createStatement();
            	 ResultSet rs=st.executeQuery("select count(*) as total from content where ctype='MusicInistrument'");
            	if(rs.next())
                      	pages=rs.getInt("total");
                 
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		
		return pages;
	}
	
	
	public int getTotalRowCount(String title)
	{
		
	int pages=0;
	Statement st;
	try{
		
		StringTokenizer str=new StringTokenizer(title,"-");
		
		System.out.println("total token");	
		String title1=title;
		String subtitle=null;
		String domain=null;
		
		String query="select count(*) as total from content where ctitle='"+title1+"'";
		
			  
		if(str.countTokens()==1)
		{
			title1=str.nextToken();
		System.out.println("only title  ->"+title1);
		
		 query="select count(*) as total from content where ctitle='"+title1+"'";
		 st=con.createStatement();
		  rs=st.executeQuery(query);
		 
		}
		else if(str.countTokens()==2)
		{
			title1=str.nextToken();
			subtitle=str.nextToken();
			System.out.println(title+"<- title and subtitle-- "+subtitle);
			 query="select count(*) as total from content where csubtitle='"+subtitle+"'";
		
			   	st=con.createStatement();
            	  rs=st.executeQuery(query);
		}
		else
		{
			title1=str.nextToken();
			subtitle=str.nextToken();
			domain=str.nextToken();
			System.out.println(title+"<- title and subtitle-- "+domain);
			 query="select count(*) as total from content where cdomain='"+domain+"'";
		
			   	st=con.createStatement();
            	  rs=st.executeQuery(query);
		}
            	if(rs.next())
                      	pages=rs.getInt("total");
		    
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return pages;
	}
	
	
	public Vector<SearchBean> getSearchCount()
	{
		
		String fname="";
		String lname="";
		
		Vector<SearchBean> vsb=null;
		
		try{
			
			pstmt=con.prepareStatement("select sid,userid,content,sdomain,TO_CHAR(sdate,'DD-MM-YYYY'),scount from searchinfo");
			
			rs=pstmt.executeQuery();
			vsb=new Vector<SearchBean>();
			
			while(rs.next())
			{
				
				int uid=rs.getInt(2);
				
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+uid);
				
				if(rs1.next())
				{
					 fname=rs1.getString(1);
					 lname=rs1.getString(2);
				}
				
				
				SearchBean sb=new SearchBean();
				
				sb.setSid(rs.getInt(1));
				sb.setFname(fname);
				sb.setLname(lname);
				sb.setContent(rs.getString(3));
				sb.setSdomain(rs.getString(4));
				sb.setSdate(rs.getString(5));
				sb.setCount(rs.getInt(6));
			
				
				
				vsb.add(sb);
				
				
				
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return vsb;
		
		
	}
	
	
	
	public Vector<SearchBean> getCountNo(String title,String sdate)
	{
		
		
		
		Vector<SearchBean> vsb=null;
		
		try{
			
			pstmt=con.prepareStatement("select scount from searchinfo where  content=? and sdate  like to_date(?,'dd-MON-yy')");
			
			pstmt.setString(1, title);
			pstmt.setString(2, DateWrapper.parseDate(sdate));
			
			
			rs=pstmt.executeQuery();
			vsb=new Vector<SearchBean>();
			
			while(rs.next())
			{
				
				
				
				
				SearchBean sb=new SearchBean();
				
				
				sb.setCount(rs.getInt(1));
			
				
				
				vsb.add(sb);
				
				
				
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return vsb;
		
		
	}
	
	
	
	
	
	public Vector<SearchBean> getSearchCountAT(String login)
	{
		
		String fname="";
		String lname="";
		int uid=0;
		
		Vector<SearchBean> vsb=null;
		
		try{
			
			pstmt=con.prepareStatement("select scount,content,sdate,sdomain from searchinfo where userid=? ");
			
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
			if(rs1.next())
			{
				
				 uid=rs1.getInt(1);
				 
				 System.out.println("in DAo from userdetails uid is..............."+uid);
			}
			
			
			pstmt.setInt(1, uid);
			
			
			
			stmt=con.createStatement();
			rs2=stmt.executeQuery("select firstname,lastname from userdetails where userid="+uid);
			
			if(rs2.next())
			{
				 fname=rs2.getString(1);
				 lname=rs2.getString(2);
			}
			
			
			rs=pstmt.executeQuery();
			vsb=new Vector<SearchBean>();
			
			while(rs.next())
			{
				
				
				
				SearchBean sb=new SearchBean();
				
				
				sb.setCount(rs.getInt(1));
				sb.setContent(rs.getString(2));
				sb.setSdate(rs.getString(3));
				sb.setSdomain(rs.getString(4));
				sb.setFname(fname);
				sb.setLname(lname);
			
				
			vsb.add(sb);
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return vsb;
		
		
	}
	
	
	
	
	
	public Vector<ContentBean> getContentInfo(String path, int cid1,String path1)
	{
		Vector<ContentBean> vcb=null;
		
		
		try{
		
		pstmt=con.prepareStatement("select *from content where cid=?");
		
		pstmt.setInt(1,cid1);
		
		rs=pstmt.executeQuery();
		
		vcb=new Vector<ContentBean>();
		while(rs.next())
		{
			ContentBean cb=new ContentBean();
			
			int cid=rs.getInt(1);
			
			cb.setCid(rs.getInt(1));
			cb.setCname(rs.getString(2));
			cb.setCsubname(rs.getString(3));
			cb.setDescription(rs.getString(4));
			cb.setCatagery(rs.getString(5));
			cb.setTopic(rs.getString(6));
			
			
			Blob b=rs.getBlob(7);
			  byte b1[]=b.getBytes(1,(int)b.length());
			   
			  OutputStream fout=new FileOutputStream(path+"/"+cid+ ".jpg");
			 // System.out.println(fout+"*********************");
			    fout.write(b1);
			
			cb.setImage(cid+".jpg");
			
			
			Blob bb=rs.getBlob(8);
			  byte b2[]=bb.getBytes(1,(int)bb.length());
			  
			  System.out.println("in DAO document from database.........."+(int)bb.length());
			   
			  OutputStream fout1=new FileOutputStream(path1+"/"+cid+".doc");
			 // System.out.println(fout+"*********************");
			    fout1.write(b2);
			
			
			
			cb.setContent(".doc");
			
			cb.setDate(rs.getString(9));
			cb.setPrice(rs.getDouble(10));
			cb.setCtype(rs.getString(11));
			
			
			
			vcb.add(cb);
			
			
		}
		
		
		
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return vcb;
}
	
	
	
}
