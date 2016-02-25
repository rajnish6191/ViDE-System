package com.nit.VIDE.util;

import com.nit.VIDE.util.AbstractDataAccessObject;

public class DBFactory
{
	public DBFactory()
	{
		new AbstractDataAccessObject().getConnection();
	}
}
