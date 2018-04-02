package com.zen.smi.service;

import com.zen.smi.bo.FineBO;
import com.zen.smi.exception.BusinessException;

public interface FineService {

	public void addFine(FineBO fine) throws BusinessException;
	public void updateFine(FineBO fine) throws BusinessException;

}
