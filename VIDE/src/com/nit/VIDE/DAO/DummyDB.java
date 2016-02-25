package com.nit.VIDE.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class DummyDB {
	
	private List<com.nit.VIDE.Bean.form1> list;
	
	public List<com.nit.VIDE.Bean.form1> getData(String query)
	{
		
		
		ContentDAO userDao=new ContentDAO();
		list=userDao.getAllTitiles();
		System.out.println(list+"@@@@@@@@@@@@@@@@@@");
		System.out.println();
		String country = null;
		query = query.toLowerCase();
		List<com.nit.VIDE.Bean.form1> matched = new ArrayList<com.nit.VIDE.Bean.form1>();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.size()+"*******************");
			country = list.get(i).getTitle().toLowerCase();
			if(country.startsWith(query)) {
				matched.add(list.get(i));
			}
		
	}
	return matched; 
}
	
}
