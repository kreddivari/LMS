package com.zen.smi.service;

import java.util.List;
import com.zen.smi.bo.MessagesBO;
import com.zen.smi.exception.BusinessException;

public interface MessagesService {

	List<MessagesBO> getAllMessages() throws BusinessException;
}
