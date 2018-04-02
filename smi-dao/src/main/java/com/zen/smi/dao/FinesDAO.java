package com.zen.smi.dao;

import java.io.Serializable;

import com.zen.smi.dao.entities.Fines;
import com.zen.smi.dao.exception.GenericDAOException;

public interface FinesDAO extends BaseDAO<Fines, Serializable> {

	public void addFine(Fines fine) throws GenericDAOException;
	public void updateFine(Fines fine) throws GenericDAOException;

}
