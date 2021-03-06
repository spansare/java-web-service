package com.ibm.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.category.Category;
import com.ibm.category.CategoryDAO;


// This class define the RESTful API to fetch the database service information
// <basepath>/api/hello

@Path("/CategoryService")
public class CategoryController {

	@GET
	@Path("/getCategories")
	@Produces("application/json")
	public String getInformation() throws Exception, IOException {
		String result = new String();
		JSONObject categoryJson = new JSONObject();
		CategoryDAO catDao = new CategoryDAO();
		List<Category> categories = catDao.getAllCategories();
		categoryJson = categoryJson.put("result", categories);
		result = categoryJson.toString();
		System.out.println("Result : " + result);
        return result;
        
	}
	
	@POST
	@Path("/createCategory")
	@Produces("text/plain")
	@Consumes("application/json")
	public String createCategory(String input) {
		String result = new String();
		
		try {
			JSONObject json = new JSONObject(input);
			CategoryDAO catDao = new CategoryDAO();
			Category category = new Category();
			
			category.setCategory_name(json.getString("name"));
			category.setShort_description(json.getString("short_description"));
			category.setLong_description(json.getString("long_description"));
			category.setImage_url(json.getString("image_url"));
			
			boolean res = catDao.createCategory(category);
			
			if(res)
				result = "Category created successfully!!!";
			else
				result = "Category creation failed. Check logs for more details.";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}