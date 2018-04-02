package com.zen.smi.dao.impl;

import java.io.Serializable;

import com.zen.smi.dao.FinesDAO;
import com.zen.smi.dao.entities.Fines;
import com.zen.smi.dao.exception.GenericDAOException;

public class FinesDAOImpl extends BaseDAOImpl<Fines, Serializable> implements FinesDAO {

	public FinesDAOImpl() {
		super(Fines.class);
	}
	
	public static void main(String[] args) throws Exception {
		FinesDAOImpl impl=new FinesDAOImpl();
		//impl.getAllBooks();
	}
	
	public void addFine(Fines fine) throws GenericDAOException {
		saveOrUpdate(fine);
	}
	public void updateFine(Fines fine) throws GenericDAOException {
		saveOrUpdate(fine);
	}

	
	
}
