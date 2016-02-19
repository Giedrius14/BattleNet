package com.battle.net.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battle.net.dao.User;
import com.battle.net.service.UsersService;

@Controller
public class AdminController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("user", users);
		return "admin";
	}
	
	/*@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public  @ResponseBody String getAllProfiles( ModelMap model ) {
		String jsonData = "[{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"},{\"firstname\":\"nidhi\",\"lastname\":\"rai\",\"address\":\"201,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-876-5432\"}]";
		return jsonData;
	}*/
/*	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public  @ResponseBody String getAllProfiles( ModelMap model ) {
		List<User> users = usersService.getAllUsers();
		
		String json = new Gson().toJson(users);
		return json;
	}*/
	
	/*@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = usersService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }*/
}
