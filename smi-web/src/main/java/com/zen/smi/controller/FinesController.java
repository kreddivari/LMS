package com.zen.smi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zen.smi.bo.FineBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.FineService;


@Controller
public class FinesController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(FinesController.class);
	
	@Autowired 
	FineService fineService;
	
	
	@RequestMapping(value = "/add_fine", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody String userJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = "SUCCESS";
		try {			
			FineBO fineBO= gson.fromJson(Json, FineBO.class);
			fineService.addFine(fineBO);		
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
}
