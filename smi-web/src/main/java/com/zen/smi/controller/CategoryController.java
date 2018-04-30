package com.zen.smi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zen.smi.bo.CategoryBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.CategoryService;


@Controller
public class CategoryController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);
	
	@Autowired 
	CategoryService categoryService;
	
	
	@RequestMapping(value = "/create_category", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody String userJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = "SUCCESS";
		try {			
			CategoryBO categoryBO= gson.fromJson(Json, CategoryBO.class);
			categoryService.createCategory(categoryBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
	@RequestMapping(value = "/category_all", method = RequestMethod.GET)
	public @ResponseBody String getAll(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = "SUCCESS";
		try {	
			List<CategoryBO> categoryBO=categoryService.getAllCategories();	
			Json=gson.toJson(categoryBO);
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
}
